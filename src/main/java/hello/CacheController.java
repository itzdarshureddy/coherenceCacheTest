package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

@Controller
public class CacheController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/cache")
    public @ResponseBody
    CacheElement greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {

        String key=name;
        NamedCache namedCache=CacheFactory.getCache("TestCache");
        String value=counter.incrementAndGet()+"";
        String cacheValue=(String)namedCache.get(key);
        if(cacheValue==null){
        namedCache.put(key,value);
            System.out.println("Value Not found in cache, pushing value to cache, key="+key);
        }
        else{
            System.out.println("Returning value from cache");
        }
        return new CacheElement(cacheValue,
                            String.format(template, name));


    }
}
