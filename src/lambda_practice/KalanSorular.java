package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

            public class KalanSorular {
            public static void main(String[] args) {
            List<String> list=new ArrayList<>();
            list.add("Elma");
            list.add("portakal");
            list.add("uzum");
            list.add("cilek");
            list.add("greyfurt");
            list.add("nar");
            list.add("mandalina");
            list.add("armut");
            list.add("elma");
            list.add("keciboynuzu");
            list.add("Ayva");
            sonHarfSiralaSon3El(list);

    }
            //S7: uzunlugu 3 ile 7 arası olan veya a ile biten elemanlardan yeni bir liste olustur
            public static List<String> aIleBıtenEl(List<String> list){

            return
                list.stream().
                        filter(t->(t.length()<7 && t.length()>3) ||t.toLowerCase().endsWith("a")).
                        collect(Collectors.toList());
}

           //S8:list elemanlarını uzunluklarına ve ikinci harflerine göre benzersiz sıralayıp yazdırın
           public static void uzunVeIknciHarfeBenzersizSirala(List<String >l){
           l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.charAt(1))).
            distinct().forEach(Utils::yazString);

          //thencomparing (): karsılastırma ıslemı ıcın bır kosul daha belırtır

}

           // S9: uzunlugu 4 ve 8 olanlar haric bir liste olusturunuz
           public static  List<String>  uzunluk4ve8Haric( List<String> l){

           return l.stream().filter(t -> t.length()!=4 && t.length()!=8).
                   collect(Collectors.toList());
}


          //S10: List elemanlarını son harfe göre sıralayıp, son 3 elemanı yazdırın
          public static void sonHarfSiralaSon3El(List<String> list){
            list.stream().
            sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
            map(t->t.substring(t.length()-3)).
            forEach(Utils::yazString);
}

}
