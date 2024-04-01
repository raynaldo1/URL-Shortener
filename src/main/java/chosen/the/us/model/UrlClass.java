package chosen.the.us.model;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity

public class UrlClass implements Serializable {


    private String originalUrl;

    private String shortenUrl;
    
    //private Long id;

    private Integer days;

    public UrlClass(Integer days) {
        this.days = days;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

  //  public Long getId() {
  //      return id;
  //  }

  //  public void setId(Long id) {
  //      this.id = id;
  //  }

    
}
