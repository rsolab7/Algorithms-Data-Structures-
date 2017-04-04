/**
 * Created by Roberto on 10/12/16.
 */
public class DailyWeather extends Day {
    int maxTemp;
    int minTemp;
    int meanTemp;
    int meanHumidity;
    int maxWind;
    int meanWind;

    public DailyWeather(int d, int m, int y){
        super(d,m,y);
    }

    public void setmaxTemp(int tmp){
        this.maxTemp = tmp;
    }
    public int getmaxTemp(){
       return maxTemp;
    }

    public void setminTemp(int tmp){
        minTemp = tmp;
    }
    public int getminTemp(){
        return minTemp;
    }

    public void setmeanTemp(int tmp){
        meanTemp = tmp;
    }
    public int getmeanTemp(){
        return meanTemp;
    }

    public void setmeanHumidity(int tmp){
        meanHumidity = tmp;
    }
    public int getmeanHumidity(){
        return meanHumidity;
    }

    public void setmaxWind(int tmp){
        maxWind = tmp;
    }
    public int getmaxWind(){
        return maxWind;
    }

    public void setmeanWind(int tmp){
        meanWind = tmp;
    }
    public int getmeanWind(){
        return meanWind;
    }


}
