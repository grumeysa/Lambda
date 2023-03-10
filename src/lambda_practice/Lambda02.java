package lambda_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Lambda02 {
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

        System.out.println(ilkHarfBykList(list));
        System.out.println(ecIleBaslayanList(list));
        yildizliYaz(list);
        System.out.println();
        System.out.println(eOlanList(list));
        System.out.println();
        lleriSil(list);
        System.out.println();
        enBykEl(list);


    }
    public static List<String> ilkHarfBykList(List<String> l){
     return    l.
                stream().
                map(t-> t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
                collect(Collectors.toList());
    }
    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static List<String> ecIleBaslayanList(List<String> liste){
      return   liste.
                stream().
                filter(t-> t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList());
    }
    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yildizliYaz(List<String> liste){
        liste.
                stream().
                map(t-> "*"+t+"*").forEach(Utils::yazString);
    }
    //S4 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eOlanList(List<String> liste){
       return liste.stream().filter(t->t.toLowerCase().contains("e")).collect(Collectors.toList());

    }
    //S5: tum 'l' leri silelim yazdiralim
    public static void lleriSil(List<String> liste){
        liste.
                stream().
                map(t->t.replaceAll("l","")).
                forEach(Utils::yazString);
    }
    //S6: List elemanlar??n?? 2.harfe gore s??ralay??p
    //ilk 5 elemandan char(karakter) say??s?? en buyuk eleman?? print ediniz.

    public static void enBykEl(List<String> liste){
        System.out.println(liste.
                stream().
                sorted(Comparator.comparing(t -> t.charAt(1))).
                limit(5).
                sorted(Comparator.comparing(String::length).reversed()).
                findFirst());
    }
}
