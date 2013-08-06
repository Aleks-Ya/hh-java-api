package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;

final class MetroInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(MetroInitializer.class);
    private static MetroInitializer dictionary;
    private IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private MetroCityDictionary metroCities;

    private MetroInitializer() {
        LOG.debug("Создаю инстанс MetroInitializer");
        loadMetro();
    }

    public static MetroInitializer getInstance() {
        if (dictionary == null) {
            dictionary = new MetroInitializer();
        }
        return dictionary;
    }

    private void loadMetro() {
        try {
            LOG.debug("Загружаю справочник метро.");
            String content = loader.loadContent(UrlConstants.METRO_URL);
            IParser<MetroCityDictionary> parse = new MetroParser();
            metroCities = parse.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            metroCities = new MetroCityDictionary();
        }
    }

}
