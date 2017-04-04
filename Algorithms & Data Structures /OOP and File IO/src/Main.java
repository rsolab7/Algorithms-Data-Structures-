import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //DailyWeather [] mylist = new DailyWeather[365]; //// FIXME: 10/12/16
        ArrayList <DailyWeather> dwList = new ArrayList <DailyWeather>();



        try{
            int i = 0;
            //Find file
            FileReader input = new FileReader("weather2015.txt");
            //Read file
            BufferedReader reader = new BufferedReader(input);
            String line;
            reader.readLine();
            while((line = reader.readLine())!= null){
                //System.out.print(line);
                String[] elements=line.split(",");
                int [] temparraylist = new int[elements.length];
                for ( int j = 0; j< elements.length; j++){
                    temparraylist[j]=Integer.parseInt(elements[j]);

                }

                //copy to daily weather
                DailyWeather dw = new DailyWeather(temparraylist[0], temparraylist[1], 2015);
                dw.setmaxTemp(temparraylist[2]);
                dw.setmeanTemp(temparraylist[3]);
                dw.setminTemp(temparraylist[4]);
                dw.setmeanHumidity(temparraylist[5]);
                dw.setmaxWind(temparraylist[6]);
                dw.setmeanWind(temparraylist[7]);
                //copy to an array list
                dwList.add(dw);
            }
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("File Not found");
        }catch (IOException e){
            e.printStackTrace();
        }

        //Check if the list contains the correct info
        /*for (int i = 0; i< dwList.size(); i++){
            System.out.print(dwList.get(i).getmaxTemp()+ " ");
            System.out.println(dwList.get(i).getmeanWind()+ " ");
        }*/



        //Find the day with the higest mean temperature
        int index = 0;
        int tmp = 0;
        for( int i = 0; i<dwList.size();i++){
            if (dwList.get(i).getmeanTemp() > tmp){
                tmp = dwList.get(i).getmeanTemp();
                index = i;
            }
        }
        //System.out.println("Index "+index);
        System.out.print("The highest mean temperature of the year was: " + dwList.get(index).getmeanTemp() + " on ");
        dwList.get(index).printDay();

        for( int i = 0; i<dwList.size();i++){
            if (dwList.get(i).getmeanHumidity() > tmp){
                tmp = dwList.get(i).getmeanHumidity();
                index = i;
            }
        }
        System.out.print("The highest mean Humidity of the year was: " + dwList.get(index).getmeanHumidity() + " on ");
        dwList.get(index).printDay();

        tmp = 0;
        for( int i = 0; i<dwList.size();i++){
            if (dwList.get(i).getmaxWind() > tmp){
                tmp = dwList.get(i).getmaxWind();
                index = i;
            }
        }
        System.out.print("The highest Max Wind of the year was: " + dwList.get(index).getmaxWind() + " on ");
        dwList.get(index).printDay();
        System.out.print("      The mean temperature that day was: " + dwList.get(index).getmeanTemp());
        //System.out.print("\n"+index);
    }
}

