package dao;

import pojo.Trips;
import result.Result;

import java.util.List;

public interface TripsDao {
    /**
     *查询目标车票信息
     * @param trips
     * @return
     * */
    public abstract List<Trips> getAimtrips(Trips trips);

    /**
     * 查询全部车票信息
     * @param trips
     * @return
     * */
    public abstract List<Trips> getAlltrips();

    /***
     * @param id
     * @return
     */
    public abstract Trips gettrips(int id);
    
    public abstract List<Trips> getOtherTrips(int id,String orginLocation,String destinationLocation);

    /**
     *订单改签后改变旧车票信息
     * @param oldId
     * @return
    * */
    public int changeOldtrips(int oldId);

    /**
     *订单改签后改变新车票信息
     * @param newId
     * @return
     * */
    public int changeNewtrips(int newId);

    /**
     * 通过id和车号查询车次信息
     * @param trips
     * @return
     */
    public abstract Trips getTripsInfoByCarInfoIdAndId (Trips trips);

    /**
     * 更新trips表
     * @param trips
     * @return
     */
    public abstract int updateTrips(Trips trips);

    public abstract int refundTrips(int personId, String carNum, String startTime, String reachTime);

    public abstract Trips getTripsInfoByCarNumAndStartTime(String carNum, String startTime);
}
