import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStore {

    private final ConcurrentHashMap<String, String> store;

    public InMemoryStore(){
        store = new ConcurrentHashMap<>();
    }

    public void set(String key, String value){
        store.put(key, value);
    }

    public String get(String key){
        return store.get(key);
    }

    public void delete(String key){
        store.remove(key);
    }
    
}
