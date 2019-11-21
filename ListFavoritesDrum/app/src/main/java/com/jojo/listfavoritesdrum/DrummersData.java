package com.jojo.listfavoritesdrum;

import java.util.ArrayList;

public class DrummersData {
    private static String [] drummerNames = {
            "Echa Soemantri",
            "Eno Gitara Ryanto",
            "Excel Mangare",
            "Gusti Hendy",
            "Ikmal Tobing",
            "Rani Ramadhany",
            "Ray Prasetya",
            "Rio Alief",
            "Yandi Andaputra",
            "Yoiqball"


    };

    private static String[] drummerDetails = {
            "Yesaya Wilander Soemantri atau lebih dikenal sebagai Echa Soemantri (lahir di Jakarta, Indonesia, 7 Juli 1989; umur 30 tahun)[1] adalah seorang drummer asal Indonesia. Ia adalah anggota dari grup musik jazz Trisum.",
            "Eno Gitara Ryanto atau dikenal sebagai Eno Netral (lahir di Jakarta, Indonesia, 11 Oktober 1979; umur 39 tahun) merupakan seorang Drummer berkebangsaan Indonesia yang juga merupakan Drummer dari grup musik Netral.",
            "Drummer kelahiran Mataram, 31 Mei 1994 ini merupakan putra sulung Ernie Mangare dan Fren Mangare yang telah mengenggam segudang prestasi mengagumkan.",
            "Gusti Erhandy Rakhmatullah (lahir di Banjarmasin, Kalimantan Selatan, 10 Maret 1980; umur 39 tahun) atau yang lebih dikenal dengan panggilan Hendy Gigi adalah seorang penabuh drum dari grup musik Gigi.",
            "Ikmal Tobing (lahir di Jakarta, 31 Maret 1989; umur 30 tahun) adalah drummer berkebangsaan Indonesia. Ikmal adalah drummer dari T.R.I.A.D dan Mahadewa.",
            "Rani Ramadhany Faishal atau dikenal dengan Rani Ramadhany (lahir di Jakarta, 2 Maret 1994; umur 25 tahun) adalah seorang Youtuber, Drummer, Aktris dan Model.",
            "Ray Prasetya, cowok kelahiran Bekasi, 22 Oktober 1997 ini, namanya mulai dikenal setelah mengikuti ajang pencarian idola, Idola Cilik. Namanya semakin terkenal setelah berperan sebagai Rendy dalam sinetron Yang Masih di Bawah Umur.",
            "Rio Alief Radantha atau Rio (lahir 17 Februari 1992; umur 27 tahun) adalah seorang musisi berkebangsaan Indonesia. Rio merupakan drummer pengganti posisi sementara Reza di grup band Noah.",
            "Riyandi Andaputra,lahir di Jakarta pada tanggal 13 Juli 1996 saat ini yandi berumur 20 tahun.Riyandi mendalami drum dari umur 6 tahun dan sudah bermain secara professional dari umur 12 tahun.",
            "Belajar drum di umur 4 tahun kemudian meneruskan belajar menjadi drummer professional dengan guru drum besar Indonesia seperti: Gilang Ramadhan, Alm Uce Haryono,Cendyluntungan dll."
    };

    private static int[] drummersImages = {
            R.drawable.echasoemantri,
            R.drawable.enonetral,
            R.drawable.excelmangare,
            R.drawable.gustihendy,
            R.drawable.ikmaltobing,
            R.drawable.rani,
            R.drawable.rayprasetya,
            R.drawable.rioalief,
            R.drawable.yandi,
            R.drawable.yoiqball
    };

    private static String [] drummersVideo = {
            "JUtS3qM-ohs",
            "gwIDn3bVHJw",
            "Qn1IypFead0",
            "oHYkgl6O0dw",
            "WR9uQB4vK2w",
            "B5oPkK80-OU",
            "qR0RFelpZCg",
            "62fKgA3pDaQ",
            "N0ghN7c09Nw",
            "N-oMSh4PBNQ"
    };

    static ArrayList<Drummer> getListData() {
        ArrayList<Drummer> list = new ArrayList<>();
        for (int position = 0; position < drummerNames.length; position++) {
            Drummer drummer = new Drummer();
            drummer.setName(drummerNames[position]);
            drummer.setDetail(drummerDetails[position]);
            drummer.setPhoto(drummersImages[position]);
           drummer.setVideo(drummersVideo[position]);
            list.add(drummer);
        }
        return list;
    }
}

