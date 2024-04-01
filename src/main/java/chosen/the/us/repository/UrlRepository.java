package chosen.the.us.repository;

import org.springframework.stereotype.Repository;

import chosen.the.us.model.UrlClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository

public class UrlRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public UrlClass save(UrlClass newURL) {
        entityManager.persist(newURL);
        return newURL;
    }

    @Transactional
    public UrlClass findByShorten(String shortenCode){
        String queryText ="SELECT u FROM URLShort WHERE u.shortenUrl = shortencode";
        TypedQuery<UrlClass> query = entityManager.createQuery(queryText, UrlClass.class);
        query.setParameter("shortenCode", shortenCode);
        return query.getSingleResult();
    }

    @Transactional 
    public void delete(UrlClass url){
        entityManager.remove(url);
    }

    @Transactional
    public UrlClass update(String shortenUrl, UrlClass updated) {
        UrlClass urlTemp = findByShorten(shortenUrl);
        entityManager.remove(findByShorten(shortenUrl));
        if (updated.getOriginalUrl() != null) {
            urlTemp.setOriginalUrl(updated.getOriginalUrl());
        }

        if (updated.getShortenUrl() != null){
            urlTemp.setShortenUrl(updated.getShortenUrl());
        }

        urlTemp.setDays(30);

        entityManager.persist(urlTemp);
        entityManager.remove(urlTemp);

        return urlTemp;

    }


}
