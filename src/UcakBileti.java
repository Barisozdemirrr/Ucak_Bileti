import java.util.Scanner;

public class UcakBileti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isYasSuccess = false, isKmSuccess = false;
        int km = 0, yas = 0, yolculukTipi;
        double indirimsizFiyat, cocukIndirim = 0.50, gencIndirim = 0.10, yasliIndirim = 0.30, gdIndirim = 0.20, perKm = 0.10,
                yasIndirimi, indirimliTutar, gitGelIndirim, toplamTutar, toplamIndirim;

        System.out.println("""
                12 yas ve altına %50 indirim
                12-24 yas arasi %10
                65 yas ve uzeri icin %30
                Cift yonlu uçuslarda ise %20 indirim uygulanir.\s""");

        while (!isYasSuccess) {
            System.out.println("Lütfen Yasinizi Giriniz : ");

            yas = input.nextInt();
            if (yas > 0) {
                isYasSuccess = true;
            } else {
                System.out.println("Hatali Tuslama Yaptiniz");

            }
        }
        while (!isKmSuccess) {
            System.out.println("Lütfen Mesafeyi Km cinsinden giriniz : ");
            km = input.nextInt();
            if (km > 0) {
                isKmSuccess = true;

            } else {
                System.out.println("Hatali Tuslama Yaptiniz");

            }
        }


        System.out.println("Lütfen Yolculuk Tipini Giriniz : 1 => Tek Yon , 2 => Gidis Donus");
        yolculukTipi = input.nextInt();


        indirimsizFiyat = km * perKm;

        switch (yolculukTipi) {
            case 1 -> {
                if (yas < 12) {
                    yasIndirimi = indirimsizFiyat * cocukIndirim;
                    indirimliTutar = indirimsizFiyat - yasIndirimi;
                    System.out.println("Normal Fiyat : " + indirimsizFiyat + "TL" + " Yapılan indirim : "
                            + yasIndirimi + "TL" + " Odenecek tutar : " + indirimliTutar + "TL");

                } else if (yas > 12 && yas < 24) {
                    yasIndirimi = indirimsizFiyat * gencIndirim;
                    indirimliTutar = indirimsizFiyat - yasIndirimi;
                    System.out.println("Normal Fiyat : " + indirimsizFiyat + "TL" + "Yapılan indirim : "
                            + yasIndirimi + "TL" + "Odenecek tutar : " + indirimliTutar + "TL");


                } else if (yas >= 65) {
                    yasIndirimi = indirimsizFiyat * yasliIndirim;
                    indirimliTutar = indirimsizFiyat - yasIndirimi;
                    System.out.println("Normal Fiyat : " + indirimsizFiyat + "TL" + " Yapılan indirim : "
                            + yasIndirimi + "TL" + " Odenecek tutar : " + indirimliTutar + "TL");

                } else {
                    System.out.println("Toplam Tutar : " + indirimsizFiyat + "TL");
                }
            }
            case 2 -> {
                if (yas < 12) {
                    yasIndirimi = indirimsizFiyat * cocukIndirim;
                    indirimliTutar = indirimsizFiyat - yasIndirimi;
                    gitGelIndirim = indirimliTutar * gdIndirim;
                    toplamIndirim = yasIndirimi + gitGelIndirim;
                    toplamTutar = indirimliTutar - gitGelIndirim;
                    System.out.println("Normal Fiyat : " + indirimsizFiyat + "TL" + " Yapılan indirim : "
                            + toplamIndirim + "TL" + " Odenecek tutar : " + toplamTutar + "TL");

                } else if (yas > 12 && yas < 24) {
                    yasIndirimi = indirimsizFiyat * gencIndirim;
                    indirimliTutar = indirimsizFiyat - yasIndirimi;
                    gitGelIndirim = indirimliTutar * gdIndirim;
                    toplamIndirim = yasIndirimi + gitGelIndirim;
                    toplamTutar = indirimliTutar - gitGelIndirim;
                    System.out.println("Normal Fiyat : " + indirimsizFiyat + "TL" + " Yapılan indirim : "
                            + toplamIndirim + "TL" + " Odenecek tutar : " + toplamTutar + "TL");
                } else if (yas > 65) {
                    yasIndirimi = indirimsizFiyat * yasliIndirim;
                    indirimliTutar = indirimsizFiyat - yasIndirimi;
                    gitGelIndirim = indirimliTutar * gdIndirim;
                    toplamIndirim = yasIndirimi + gitGelIndirim;
                    toplamTutar = indirimliTutar - gitGelIndirim;
                    System.out.println("Normal Fiyat : " + indirimsizFiyat + "TL" + " Yapılan indirim : "
                            + toplamIndirim + "TL" + " Odenecek tutar : " + toplamTutar + "TL");

                } else {
                    gitGelIndirim = indirimsizFiyat * gdIndirim;
                    toplamTutar = indirimsizFiyat - gitGelIndirim;
                    System.out.println("Normal Fiyat : " + indirimsizFiyat + "TL" + " Yapılan indirim : "
                            + gitGelIndirim + "TL" + " Odenecek tutar : " + toplamTutar + "TL");
                }
            }
            default -> System.out.println("Hatali tuslama yaptiniz lütfen tekrar deneyiniz.");
        }


    }
}
