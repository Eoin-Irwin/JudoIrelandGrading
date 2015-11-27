package com.example.eoins.judoirelandgrading.adapter;

/**
 * created by Eoin on 30-10-15
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Green extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Green() {

    }

    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> JudoMoves = new LinkedHashMap<>();
        List<String> Ukemi = new ArrayList<>();
        Ukemi.add("All Breakfalls");

        List<String> NagaWaza = new ArrayList<>();
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


        List<String> OsaekomiWaza = new ArrayList<>();
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

        List<String> ShimeWaza = new ArrayList<>();
        ShimeWaza.add("Okuri Eri Jime");
        ShimeWaza.add("Kata Ha Jime");
        ShimeWaza.add("Tsurikomi Jime");
        ShimeWaza.add("Gyaku Juji Jime");
        ShimeWaza.add("Kata Juji Jime");
        ShimeWaza.add("Hadake Jime");
        ShimeWaza.add("Nami Juji Jime");

        List<String> KansetsuWaza = new ArrayList<>();
        KansetsuWaza.add("Hiza Getame");
        KansetsuWaza.add("Ashi Getame");
        KansetsuWaza.add("Ude Getame");
        KansetsuWaza.add("Ude Garami");
        KansetsuWaza.add("Juji Getame");

        List<String> GonosenNoKata = new ArrayList<>();
        GonosenNoKata.add("O-soto-gari - O-soto-gari\n" +
                "Hiza Guruma - Hiza Guruma\n" +
                "Ouchi-Gari - De-Ashi-Barai/Okuri-Ashi-Barai\n");
        GonosenNoKata.add("De-ashi-barai - De-Ashi-barai\n" +
                "Ko-Soto-Gake - Tai-Otoshi\n" +
                "Ko-Uchi-Gari - Sasae-Tsuri-komi-Ashi");
        GonosenNoKata.add("Kube-Nage - Ushiro-Goshi\n" +
                "Koshi-Guruma - Uki-Goshi\n" +
                "Hane-Goshi - Sasae-Tsurikomi-Ashi\n");

        List<String> NagaNoKata = new ArrayList<>();
        NagaNoKata.add("Koshi Waza");
        NagaNoKata.add("Te Waza");

        List<String> Terminology = new ArrayList<>();
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

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
