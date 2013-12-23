package hello;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CacheElement")
public class CacheElement {
    @XmlElement
    private  String key;
    @XmlElement
    private   String value;

    public CacheElement() {
    }

    public CacheElement(String id, String value) {
        this.key = id;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
