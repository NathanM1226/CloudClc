package com.gcu.data;

import java.util.List;

public interface carsInterface {
    public List<carsModel> getCars();
    public long addOne(carsModel car);
    public boolean deleteOne(int id);
    public carsModel updateOne(int idToUpdate, carsModel updateCar);
}
