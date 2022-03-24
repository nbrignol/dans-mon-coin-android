package fr.nbrignol.dansmoncoin;

import java.util.ArrayList;
import java.util.List;

public class PoiMockDao implements PoiDaoInterface {

    List<Poi> dataList = new ArrayList<Poi>();
    PoiDaoListener listener;

    @Override
    public void init(PoiDaoListener listener) {
        this.listener = listener;

        dataList.add(new Poi("Le super portail de l'IUT"));
        dataList.add(new Poi("La salle de classe"));
        dataList.add(new Poi("Le resto U"));

        this.listener.onDataChanged();
    }

    @Override
    public Poi getPoi(int index) {
        return dataList.get(index);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }
}
