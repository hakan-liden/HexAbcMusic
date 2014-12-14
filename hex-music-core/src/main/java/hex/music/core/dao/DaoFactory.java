package hex.music.core.dao;

import javax.persistence.EntityManager;

/**
 * Created 2014-12-10
 *
 * @author hl
 */
public class DaoFactory {

    private final EntityManager em;

    public DaoFactory(EntityManager em) {
        this.em = em;
    }

    public MetaDataDao getMetaDataDao() {
        return new MetaDataDao(em);
    }
}
