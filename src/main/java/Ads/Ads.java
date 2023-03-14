package Ads;

import java.util.List;

public interface Ads {
    List<Ad> all();

    public long insert(Ad ad);

}
