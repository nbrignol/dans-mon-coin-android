package fr.nbrignol.dansmoncoin;

public interface PoiDaoInterface {
    public void init(PoiDaoListener listener);
    public Poi getPoi(int index);
    public int getCount();
}
