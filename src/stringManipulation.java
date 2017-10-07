/**
* Created by anhtran on 9/26/17.
*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class stringManipulation {

/*Anh Tran- Dickinson College graduating in May 2018
Applying for full-time positions


accounts,


You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times you showed an ad on each individual domain. Every line consists of a count and a domain name. It looks like this:

counts = [ "900,google.com",
  "100,mail.google.com",
 "60,mail.yahoo.com",
 "10,mobile.sports.yahoo.com",
 "40,sports.yahoo.com",
 "300,yahoo.com",
 "10,stackoverflow.com",
 "2,en.wikipedia.org",
 "1,es.wikipedia.org" ]

Write a function that interprets this input and outputs the number of hits that were recorded on each domain AND each domain under it. For example, a click on "sports.yahoo.com" counts for "sports.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "sports" and "sports.yahoo" are not valid domains.)

Expected output (in any order):
1320  com
900  google.com
410  yahoo.com
60  mail.yahoo.com
10  mobile.sports.yahoo.com
50  sports.yahoo.com
10  stackoverflow.com
3  org
3  wikipedia.org
2  en.wikipedia.org
1  es.wikipedia.org

map (String, Integer)
go through each string s  in the array - n
for(each char in s)  -n
int cur = 0;
String curD = "";
if s.charAt(i) == ,
  cur = the number before the ","
if s.charAt(i) == '.'

  if(!map.contains domaine)
    curD = the domaine before .
    add to map,0
  map.put(curD,curValue + cur);



*/
    public static HashMap<String, Integer> countDomain(String[] counts){
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < counts.length; i++){
            String curVal = counts[i];

            int doIndex = -1;
            int curCount = 0;

            for(int j = 0; j < curVal.length(); j++){
                String curD = "";

                //"900,google.com"

                if (curVal.charAt(j) == ',') {
                    curCount = Integer.parseInt(curVal.substring(0,j));
                    doIndex = j+1;
                }
                if(curVal.charAt(j) == '.') {
                    curD = curVal.substring(doIndex, curVal.length());
                    doIndex = j+1;
                }
                if(j == curVal.length() -1) {
                    curD = curVal.substring(doIndex, j+1);
                }

                if(!map.containsKey(curD)) {
                    map.put(curD, 0);
                }

                if(curD.length() != 0 && map.containsKey(curD)){
                    int curMapCount = map.get(curD);
                    map.put(curD, map.get(curD) + curCount);
                }
            }
        }

        return map;
    }

    public static void main(String[] args) {

        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "2,en.wikipedia.org",
                "1,es.wikipedia.org" };

        HashMap<String, Integer> map = countDomain(counts);

        for (String domain: map.keySet() ) {
            System.out.println(map.get(domain) + " " + domain);
        }
    }
}


