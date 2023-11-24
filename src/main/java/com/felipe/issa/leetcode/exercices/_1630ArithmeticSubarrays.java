package com.felipe.issa.leetcode.exercices;

import sun.plugin2.message.Message;

import java.text.MessageFormat;
import java.util.*;

public class _1630ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < l.length; i++) {
            result.add(check(nums, l, r, i));
        }

        return result;
    }

    public boolean check(int[] nums, int[] l, int[] r, int i) {
        int[] arr = new int[r[i] - l[i] + 1];

        for(int index = l[i], j = 0; index <= r[i]; index++, j++) {
            arr[j] = nums[index];
        }
        Arrays.sort(arr);
        Integer sum = arr[1] - arr[0];
        for(int index = 2; index < arr.length; index ++) {
            int diff = arr[index] -arr[index-1];
            if(diff != sum) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Boolean> output, expected;
        output = new _1630ArithmeticSubarrays().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
        expected = Arrays.asList(true, false, true);
        System.out.println(MessageFormat.format("Is same: {0}. Desired: {1}, got: {2}", expected.equals(output), expected, output));

        output = new _1630ArithmeticSubarrays().checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10});
        expected = Arrays.asList(false,true,false,false, true, true);
        System.out.println(MessageFormat.format("Is same: {0}. Desired: {1}, got: {2}", expected.equals(output), expected, output));

        output = new _1630ArithmeticSubarrays().checkArithmeticSubarrays(new int[]{3500,2310,-3465,-3025,-165,-2145,-880,-1155,-1595,-1430,-3300,-496,-560,-80,-144,-320,-400,-528,-480,-448,-224,-16,-512,-48,-304,-544,-352,-464,-288,-192,-368,-112,-176,-208,517,893,611,752,470,1316,1363,1269,94,799,1410,235,940,47,564,376,1034,846,423,329,1457,1128,987,1175,705,658,1222,141,188,1081,282,-1444,-2508,-2432,-3192,-5016,-1520,-4560,-3496,-4104,-4180,-1824,-2052,-228,-380,-2204,-4484,-3116,-4256,-2356,-4788,-304,-1748,-1140,-4864,-912,-1216,-4408,-1064,-4636,-5092,-532,-1900,-3344,-3648,-3572,-3724,-3420,-684,-4940,-1976,-76,-456,-3268,-3876,-988,-608,-3952,-5168,-2964,-1596,-2280,-152,-1292,175,950,800,1725,1050,750,1350,1125,25,1275,1200,1550,100,975,300,1100,700,125,675,1075,550,1700,1175,500,525,625,450,400,1325,350,1500,900,225,875,775,925,928,58,986,696,174,522,870,406,754,232,812,116,464,88,64,72,56,104,80,40,16,48,96,32,8,24,250,475,275,1450,850,725,50,1225,-2262,-1450,-58,-1160,-2958,-3828,-2030,-1218,-928,-2320,-1624,-3770,-1392,-754,-522,-2610,-3596,-3248,-3422,-986,-2552,-3132,-2900,-1914,-1276,1710,665,-182,-624,-442,-1430,-390,-78,-1326,-338,-1456,-156,-1300,-858,-1742,-962,-572,-832,-1118,-1560,-910,-1794,-1534,-988,-1144,-312,-1092,-676,-1482,-936,-1690,-1066,-130,-1716,-1352,-234,-1612,-416,-1222,-1586,-1170,-546,-104,-260,-286,-806,-1274,-1768,-26,-468,-780,-598,-1196,-1508,-364,-520,-1014,-1040,-1664,-754,-650,-52,-1404,-1248,-494,-702,-1638,-728,-208,-884,-1378,-1820,640,1152,768,864,608,480,96,64,1120,1088,256,1024,960,352,192,32,512,320,1248,1184,672,160,416,448,928,896,224,992,1056,544,576,736,384,800,832,288,128,704,1216,46,322,345,-4018,-689,-795,-636,-583,-53}, new int[]{122}, new int[]{124});
        expected = Arrays.asList(true);
        System.out.println(MessageFormat.format("Is same: {0}. Desired: {1}, got: {2}", expected.equals(output), expected, output));

        output = new _1630ArithmeticSubarrays().checkArithmeticSubarrays(new int[]{207,-144,-648,730,511,365,584,657,73,292,146,219,438,609,174,87,-438,-730,-73,-511,65,91,117,-256,-384,-576,-64,-252,-210,-378,-84,-336,-42,-126,-168,-420,-294,-159,-106,-212,-530,-318,-265,144,108,288,216,72,360,324,180,36,252,-190,261,-56,-504,-112,-168,-280,485,97,873,388,582,194,679,776,291,970,-61,-244,-427,-183,207,-20,-60,-90,-40,-10,-100,-50,-30,-70,-80,-36,-284,525,-52,-208,-312,-740,-592,-32,-128,-320,-256,-168,-112,-252,-56,-280,-84,-140,-28,-224,-196,261,-310,-620,-558,-248,-372,-434,-124,-62,267,89,178,-120,-144,-72,98,294,196,490,980,392,588,350,315,210,140,105,35,280,70,245,175,144,83,249,747,498,166,581,830,415,664,332,332,581,747,249,166,415,83,830,498,664,6,-648,-324,-162,-567,-243,-810,-729,-405,-480,-192,-96,-288,-384,96,48,-232,-348,-116,-290,-406,-174,-580,-522,-464,12,16,8,987},
            new int[]{149},
            new int[]{151});
        expected = Arrays.asList(false);
        System.out.println(MessageFormat.format("Is same: {0}. Desired: {1}, got: {2}", expected.equals(output), expected, output));

    }
}
