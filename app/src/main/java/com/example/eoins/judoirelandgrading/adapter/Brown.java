package com.example.eoins.judoirelandgrading.adapter;
/**
 * created by Eoin on 30-10-15
 */

import android.app.Fragment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//Class Brown creates a Fragment
//By extending from it
public class Brown extends Fragment {

    //A list that will iterate in the order that the
    //strings are placed into the code
    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> JudoMoves = new LinkedHashMap<>();
        //List category "Ukemi" becoming an array list
        List<String> Ukemi = new ArrayList<>();
        Ukemi.add("All Breakfalls");

        //List category "NagaWaza" becoming an array list
        //Moves being added into that array list also
        List<String> NagaWaza = new ArrayList<>();
        NagaWaza.add("O Soto Guruma");
        NagaWaza.add("Uki Waza");
        NagaWaza.add("Yoko Wakare");

        NagaWaza.add("Yoko Guruma");
        NagaWaza.add("Ushiro Goshi");
        NagaWaza.add("Uranage");
        NagaWaza.add("Sumi Otoshi");
        NagaWaza.add("Yoko Gake");

        NagaWaza.add("Sumi Gaeshi");
        NagaWaza.add("Tani Otoshi");
        NagaWaza.add("Hane Makekomi");
        NagaWaza.add("Sukui Nage");
        NagaWaza.add("Utsuri Goshi");
        NagaWaza.add("O Guruma");
        NagaWaza.add("O Soto Makekomi");
        NagaWaza.add("Uki Otoshi");

        NagaWaza.add("Ko Soto Gake");
        NagaWaza.add("Tsuri Goshi");
        NagaWaza.add("Yoko Otoshi");
        NagaWaza.add("Ashi Guruma");
        NagaWaza.add("Hane Goshi");
        NagaWaza.add("Harai Tsurikomi Ashi");
        NagaWaza.add("Tomoe Nage");
        NagaWaza.add("Kata Guruma");
        NagaWaza.add("Koshi Guruma");
        NagaWaza.add("Tsurikomi Goshi");
        NagaWaza.add("Okuri Ashi Barai");
        NagaWaza.add("Harai Goshi");
        NagaWaza.add("Tai Otoshi");
        NagaWaza.add("Uchimata");
        NagaWaza.add("Harai Goshi");
        NagaWaza.add("Ippon Seoi Nage (Shoulder Throw)");
        NagaWaza.add("O Soto Gari");
        NagaWaza.add("O Goshi");
        NagaWaza.add("Ouchi Gari");
        NagaWaza.add("Morote Seoi Nage");
        NagaWaza.add("Ko Soto Gari");
        NagaWaza.add("Ko Uchi Gari");
        NagaWaza.add("De Ashi Barai");
        NagaWaza.add("Hiza Guruma");
        NagaWaza.add("Uki Goshi");
        NagaWaza.add("Sasae Tsurakomi Ashi");

        //List category "OsaekomiWaza" becoming an array list
        //Moves being added into that array list also
        List<String> OsaekomiWaza = new ArrayList<>();
        OsaekomiWaza.add("Kuzure Yoko Shiho Getame");
        OsaekomiWaza.add("Makura Kesa Getame");
        OsaekomiWaza.add("Tate Shiho Getame");
        OsaekomiWaza.add("Ushiro Kesa Getame");
        OsaekomiWaza.add("Kesure Kami Shiho Getame");
        OsaekomiWaza.add("Yoko Shiho Getame");
        OsaekomiWaza.add("Kezure Kesa Getame");
        OsaekomiWaza.add("Kata Getame");
        OsaekomiWaza.add("Mune Getame");
        OsaekomiWaza.add("Kesa Getame");
        OsaekomiWaza.add("Kami Shiho Getame");

        //List category "ShimeWaza" becoming an array list
        //Moves being added into that array list also
        List<String> ShimeWaza = new ArrayList<>();
        ShimeWaza.add("Sode Guruma");
        ShimeWaza.add("Katsugi Jime");
        ShimeWaza.add("Ryote Jime");
        ShimeWaza.add("Okuri Eri Jime");
        ShimeWaza.add("Kata Ha Jime");
        ShimeWaza.add("Tsurikomi Jime");
        ShimeWaza.add("Gyaku Juji Jime");
        ShimeWaza.add("Kata Juji Jime");
        ShimeWaza.add("Hadake Jime");
        ShimeWaza.add("Nami Juji Jime");

        //List category "KansetsuWaza" becoming an array list
        //Moves being added into that array list also
        List<String> KansetsuWaza = new ArrayList<>();
        KansetsuWaza.add("Waki Getame");
        KansetsuWaza.add("Kanuki Getame");
        KansetsuWaza.add("Hiza Getame");
        KansetsuWaza.add("Ashi Getame");
        KansetsuWaza.add("Ude Getame");
        KansetsuWaza.add("Ude Garami");
        KansetsuWaza.add("Juji Getame");

        //List category "GonosenNoKata" becoming an array list
        //Moves being added into that array list also
        List<String> GonosenNoKata = new ArrayList<>();
        GonosenNoKata.add("O-soto-gari - O-soto-gari\n" +
                "Hiza Guruma - Hiza Guruma\n" +
                "Ouchi-Gari - De-Ashi-Barai/Okuri-Ashi-Barai\n");
        GonosenNoKata.add("De-ashi-barai - De-Ashi-barai\n" +
                "Ko-Soto-Gake - Tai-Otoshi\n" +
                "Ko-Uchi-Gari - Sasae-Tsuri-komi-Ashi");
        GonosenNoKata.add("Kube-Nage - Ushiro-Goshi\n" +
                "Koshi-Guruma - Uki-Goshi\n" +
                "Hane-Goshi - Sasae-Tsurikomi-Ashi");
        GonosenNoKata.add("Harai-Goshi - Utsuri-Goshi\n" +
                "Uchi-Mata - Te-Guruma\n" +
                "Kata-Seoi - Sumi-Gaeshi");


        //List category "NagaNoKata" becoming an array list
        //Moves being added into that array list also
        List<String> NagaNoKata = new ArrayList<>();
        NagaNoKata.add("Te Waza");
        NagaNoKata.add("Koshi Waza");
        NagaNoKata.add("Ashi Waza");
        NagaNoKata.add("Ma Sutemi Waza");
        NagaNoKata.add("Yoko Sutemi Waza");

        //List category "Terminology" becoming an array list
        //words being added into that array list also
        List<String> Terminology = new ArrayList<>();
        Terminology.add("Keikoku");
        Terminology.add("Chui");
        Terminology.add("Shido");
        Terminology.add("Ippon");
        Terminology.add("Wazari");
        Terminology.add("Yuko");
        Terminology.add("Koka");
        Terminology.add("Sone Mama");
        Terminology.add("Yoshi");
        Terminology.add("Tori");
        Terminology.add("Uki");
        Terminology.add("Hansoku-Make");
        Terminology.add("Tachiwaza");
        Terminology.add("Osaekomiwaza");
        Terminology.add("Shimewaza");
        Terminology.add("Kansetsuwaza");
        Terminology.add("Katamewaza");
        Terminology.add("Sensini");
        Terminology.add("Tatame");
        Terminology.add("Judogi");
        Terminology.add("Obi");
        Terminology.add("Osaekomi");
        Terminology.add("Toketa");
        Terminology.add("Hajime");
        Terminology.add("Matte");
        Terminology.add("Sore Made");
        Terminology.add("Sensei");
        Terminology.add("Rei");
        Terminology.add("Dojo");

        //All moves from above being put into the parent
        //Parent layout called JudoMoves
        JudoMoves.put("Ukemi", Ukemi);
        JudoMoves.put("Naga Waza (Throwing Techniques)", NagaWaza);
        JudoMoves.put("Osaekomi Waza (Holding Techniques)", OsaekomiWaza);
        JudoMoves.put("Shime Waza (Strangles)", ShimeWaza);
        JudoMoves.put("Kansetsu Waza (Armlocks)", KansetsuWaza);
        JudoMoves.put("Gonosen No Kata", GonosenNoKata);
        JudoMoves.put("Naga No Kata", NagaNoKata);
        JudoMoves.put("Terminology", Terminology);

        return JudoMoves;

    }
}