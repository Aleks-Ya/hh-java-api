package ru.yaal.project.hhapi.loader.cache;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TwoLevelStorageTest {
    private final String name1 = "http://sonar.com/download?v=3&a=aaa";
    private final String content1 = "Кошка";
    private final String name2 = "http://mail.ru?abv=678&blso=55";
    private final String content2 = "Дельфин";
    private final ICache fast = PowerMockito.spy(new MemoryCache("Fast Cache", 1000));
    private final ICache slow = PowerMockito.spy(new MemoryCache("Slow Cache", 1000));
    private final ICache twoLevel = new TwoLevelCache(fast, slow);

    @Test
    public void testSearch() throws Exception {
        slow.save(name1, content1);
        assertEquals(content1, slow.search(name1));
        assertNull(fast.search(name1));
        assertEquals(content1, twoLevel.search(name1));
        assertEquals(content1, fast.search(name1));
    }

    @Test
    public void testSave() throws Exception {
        twoLevel.save(name1, content1);
        twoLevel.save(name2, content2);
        verify(slow, times(1)).save(name1, content1);
        verify(slow, times(1)).save(name2, content2);
        verify(fast, times(1)).save(name1, content1);
        verify(fast, times(1)).save(name2, content2);
        assertEquals(content1, slow.search(name1));
        assertEquals(content1, fast.search(name1));
        assertEquals(content1, twoLevel.search(name1));
        assertEquals(content2, slow.search(name2));
        assertEquals(content2, fast.search(name2));
        assertEquals(content2, twoLevel.search(name2));
    }

    @Test
    public void testDelete() throws Exception {
        twoLevel.save(name1, content1);
        assertEquals(content1, slow.search(name1));
        assertEquals(content1, fast.search(name1));
        assertEquals(content1, twoLevel.search(name1));
        twoLevel.delete(name1);
        verify(slow, times(1)).delete(name1);
        verify(fast, times(1)).delete(name1);
        assertNull(slow.search(name1));
        assertNull(fast.search(name1));
        assertNull(twoLevel.search(name1));
    }

    @Test
    public void testClear() throws Exception {
        twoLevel.save(name1, content1);
        twoLevel.save(name2, content2);
        assertEquals(content1, slow.search(name1));
        assertEquals(content1, fast.search(name1));
        assertEquals(content1, twoLevel.search(name1));
        assertEquals(content2, slow.search(name2));
        assertEquals(content2, fast.search(name2));
        assertEquals(content2, twoLevel.search(name2));
        twoLevel.clear();
        verify(slow, times(1)).clear();
        verify(fast, times(1)).clear();
        assertNull(slow.search(name1));
        assertNull(fast.search(name1));
        assertNull(twoLevel.search(name1));
        assertNull(slow.search(name2));
        assertNull(fast.search(name2));
        assertNull(twoLevel.search(name2));
    }
}
