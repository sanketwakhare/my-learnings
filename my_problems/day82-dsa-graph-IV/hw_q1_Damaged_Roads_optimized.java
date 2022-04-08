/* Damaged Roads */

/* Problem Description

You are the Prime Minister of a country and once you went for a world tour.
After 5 years, when you returned to your country, you were shocked to see the condition of the roads between the cities. So, you plan to repair them, but you cannot afford to spend a lot of money.

The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.

The cost of repairing a road between (i, j) and (i + 1, j) is A[i]. The cost of repairing a road between (i, j) and (i, j + 1) is B[j].

Return the minimum cost of repairing the roads such that all cities can be visited from city indexed (0, 0).

As the cost can be large, return the cost modulo 109+7.


Problem Constraints

1 <= N, M <= 10^5
1 <= A[i], B[i] <= 10^3


Input Format

The first argument will be an integer array, A, of size N.
The second argument will be an integer array, B, of size M.



Output Format

Return an integer representing the minimum possible cost.



Example Input

Input 1:

 A = [1, 1, 1]
 B = [1, 1, 2]
Input 2:

 A = [1, 2, 3]
 B = [4, 5, 6]


Example Output

Output 1:

 16
Output 2:

 39


Example Explanation

Explanation 1:

 The minimum cost will be 16 if we repair the roads in the following way:
 Repair the roads from the all cities in row 0 to row 1 i.e. (0, j) to (1, j) (0 <= j <= 3), so that the cost will be 4 (A[0] * 4).
 Repair the roads from the all cities in row 1 to row 2 i.e. (1, j) to (2, j) (0 <= j <= 3), so that the cost will be 4 (A[1] * 4).
 Repair the roads from the all cities in row 2 to row 3 i.e. (2, j) to (3, j) (0 <= j <= 3), so that the cost will be 4 (A[2] * 4).
 Repair the roads (0, 0) to (0, 1), (0, 1) to (0, 2), (0, 2) to (0, 3), so that the cost will be B[0] + B[1] + B[2] = 4.
 Total cost will be 16.
 
Explanation 2:

 The minimum possible cost will be 39. */

import java.util.Arrays;

/* Accepted solution */
public class hw_q1_Damaged_Roads_optimized {

    class Pair implements Comparable<Pair> {
        int weight;
        boolean isVertical;

        public Pair(int weight, boolean isVertical) {
            this.weight = weight;
            this.isVertical = isVertical;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public int solve(int[] A, int[] B) {

        long p = 1000000007;
        long minCost = 0;
        long n = A.length + 1;
        long m = B.length + 1;

        // maintain a N + M size array and store the weights and a flag to identify if
        // weight is for vertical or horizontal edge
        Pair[] temp = new Pair[A.length + B.length];
        int i;
        for (i = 0; i < A.length; i++) {
            temp[i] = new Pair(A[i], true);
        }
        for (int j = 0; j < B.length; j++) {
            temp[i++] = new Pair(B[j], false);
        }
        // sort the array by weight
        Arrays.sort(temp);

        // for a N nodes there can be N-1 edges in minimum spanning tree (here N = n+m)
        long targetEdges = n * m - 1;
        i = 0;
        while (targetEdges > 0) {

            Pair pair = temp[i];
            if (pair.isVertical) {
                long wt = ((m % p) * (pair.weight % p)) % p;
                minCost = ((minCost % p) + (wt % p)) % p;
                // decrease n every time possible vertical edges are considered
                n--;
                // reduce target edges count by m as m edges are considered
                targetEdges -= m;
            } else {
                long wt = ((n % p) * (pair.weight % p)) % p;
                minCost = ((minCost % p) + (wt % p)) % p;
                // decrease m every time possible horizontal edges are considered
                m--;
                // reduce target edges count by n as n edges are considered
                targetEdges -= n;
            }
            i++;
        }
        return (int) minCost;
    }

    public static void main(String[] args) {

        hw_q1_Damaged_Roads_optimized t1 = new hw_q1_Damaged_Roads_optimized();
        int[] A, B;

        // test case 1
        A = new int[] { 1, 1, 1 };
        B = new int[] { 1, 1, 2 };
        System.out.println(t1.solve(A, B)); // 16

        // test case 2
        A = new int[] { 1, 2, 3 };
        B = new int[] { 4, 5, 6 };
        System.out.println(t1.solve(A, B)); // 39

        // test case 3 - Memory Limit Exceeded
        A = new int[] { 701, 543, 371, 402, 208, 335, 208, 156, 683, 205, 149, 82, 340, 581, 298, 177, 92, 929, 916, 91,
                702, 508, 759, 429, 6, 557, 532, 968, 742, 636, 219, 859, 584, 442, 244, 444, 781, 950, 232, 291, 647,
                563, 62, 6, 276, 554, 484, 628, 256, 496, 259, 738, 524, 214, 75, 718, 80, 107, 244, 18, 73, 943, 118,
                738, 410, 759, 900, 980, 845, 811, 951, 727, 138, 411, 54, 160, 513, 321, 530, 108, 61, 517, 647, 887,
                921, 988, 388, 24, 517, 891, 528, 141, 171, 104, 235, 672, 70, 189, 478, 304, 607, 611, 70, 394, 900,
                918, 712, 688, 343, 62, 54, 839, 539, 881, 966, 926, 109, 30, 580, 377, 449, 988, 858, 468, 214, 716,
                917, 585, 55, 769, 39, 898, 882, 655, 962, 203, 389, 4, 477, 154, 107, 333, 244, 10, 310, 658, 561, 708,
                634, 170, 678, 220, 610, 680, 823, 864, 998, 782, 364, 144, 443, 172, 402, 23, 889, 206, 902, 1000, 348,
                664, 350, 447, 531, 570, 615, 803, 251, 185, 106, 479, 941, 737, 768, 301, 839, 754, 958, 27, 405, 936,
                450, 576, 426, 17, 348, 503, 561, 463, 744, 880, 184, 734, 136, 731, 255, 433, 237, 617, 241, 266, 87,
                615, 253, 566, 530, 126, 870, 953, 392, 961, 73, 981, 211, 170, 783, 193, 609, 511, 399, 916, 687, 113,
                981, 736, 195, 527, 964, 347, 143, 728, 787, 670, 907, 855, 706, 360, 785, 608, 279, 956, 82, 957, 933,
                273, 329, 478, 672, 772, 443, 172, 252, 564, 326, 426, 617, 716, 117, 831, 145, 808, 422, 320, 76, 270,
                646, 440, 26, 109, 368, 910, 21, 539, 730, 638, 275, 769, 223, 224, 635, 110, 283, 487, 753, 981, 664,
                381, 646, 961, 598, 143, 226, 22, 376, 804, 700, 349, 831, 77, 649, 909, 91, 283, 89, 250, 931, 931, 77,
                999, 830, 72, 672, 501, 848, 801, 264, 199, 726, 830, 417, 430 };
        B = new int[] { 451, 927, 529, 434, 925, 763, 241, 773, 791, 56, 731, 450, 630, 178, 268, 786, 846, 661, 385,
                306, 810, 193, 950, 727, 588, 737, 398, 425, 309, 306, 997, 557, 96, 428, 54, 774, 116, 278, 243, 376,
                605, 254, 143, 422, 627, 955, 583, 736, 224, 368, 934, 170, 391, 68, 125, 368, 778, 957, 232, 504, 201,
                677, 647, 670, 704, 499, 700, 279, 522, 894, 814, 287, 434, 449, 264, 691, 168, 362, 127, 741, 949, 86,
                832, 661, 71, 135, 500, 61, 519, 966, 99, 229, 647, 57, 653, 793, 597, 194, 946, 911, 41, 198, 364, 767,
                442, 877, 428, 252, 642, 364, 117, 330, 149, 538, 365, 142, 30, 617, 167, 741, 694, 696, 196, 218, 393,
                470, 293, 922, 614, 966, 511, 867, 472, 839, 562, 877, 471, 282, 298, 64, 778, 707, 334, 163, 612, 447,
                253, 297, 477, 160, 343, 718, 625, 127, 999, 437, 612, 981, 258, 210, 591, 479, 476, 382, 724, 303, 179,
                212, 904, 14, 868, 870, 78, 313, 124, 11, 672, 299, 916, 297, 563, 463, 154, 153, 777, 997, 22, 699,
                651, 659, 706, 890, 34, 983, 92, 895, 515, 756, 965, 338, 643, 71, 474, 698, 45, 112, 499, 863, 507, 74,
                680, 999, 435, 131, 141, 799, 520, 180, 515, 539, 373, 949, 145, 602, 738, 528, 686, 103, 712, 202, 710,
                502, 538, 175, 110, 815, 597, 789, 444, 439, 5, 392, 638, 768, 189, 633, 969, 143, 267, 758, 405, 151,
                235, 547, 525, 121, 347, 105, 354, 453, 628, 135, 824, 607, 537, 973, 606, 898, 907, 883, 837, 989, 934,
                781, 194, 663, 698, 837, 587, 880, 164, 737, 363, 77, 261, 666, 734, 748, 551, 158, 994, 200, 535, 805,
                388, 550, 755, 564, 876, 957, 362, 831, 368, 377, 211, 748, 276, 684, 271, 602, 909, 345, 449, 442, 493,
                704, 771, 8, 920, 702, 980, 639, 332, 345, 437, 621, 75, 205, 56, 88, 56, 206, 136, 83, 286, 209, 853,
                281, 88, 913, 29, 398, 587, 801, 492, 152, 140, 339, 249, 577, 532, 535, 732, 933, 247, 993, 783, 796,
                476, 509, 148, 608, 562, 379, 262, 254, 635, 693, 555, 466, 839, 761, 746, 594, 652, 756, 229, 782, 826,
                619, 146, 530, 697, 684, 179, 15, 312, 94, 331, 197, 284, 627, 683, 298, 579, 608, 958, 583, 721, 755,
                84, 163, 227, 924, 624, 360, 888, 466, 292, 699, 676, 525, 961, 445, 264, 564, 77, 598, 79, 574, 820,
                330, 293, 679, 577, 86, 997, 281, 402, 939, 742, 171, 905, 613, 698, 960, 945, 619, 912, 36, 426, 172,
                859, 192, 744, 979, 386, 826, 380, 305, 46, 617, 954, 332, 652, 156, 422, 348, 875, 507, 910, 335, 188,
                900, 630, 476, 923, 15, 243, 224, 52, 184, 393, 28, 189, 77, 144, 509, 756, 55, 647, 301, 399, 575, 348,
                56, 106, 374, 245, 260, 498, 130, 894, 535, 10, 468, 217, 381, 578, 527, 800, 194, 712, 994, 176, 129,
                686, 423, 803, 256, 351, 785, 934, 887, 698, 901, 11, 963, 429, 356, 486, 783, 886, 633, 735, 858, 616,
                226, 577, 572, 342, 682, 880, 809, 676, 727, 345, 782, 261, 101, 936, 334, 184, 461, 583, 251, 549, 162,
                176, 492, 783, 968, 561, 709, 141, 46, 390, 568, 157, 997, 160, 988, 29, 295, 796, 905, 943, 429, 81,
                788, 36, 472, 411, 235, 192, 404, 100, 87, 949, 841, 732, 527, 502, 674, 841, 762, 105, 15, 72, 492,
                785, 123, 211, 440, 371, 323, 793, 475, 827, 775, 461, 722, 379, 685, 498, 132, 801, 987, 754, 394, 94,
                172, 914, 587, 811, 105, 604, 890, 773, 664, 500, 389, 41, 347, 788, 224, 991, 70, 735, 978, 251, 966,
                103, 838, 195, 880, 673, 434, 242, 762, 525, 185, 128, 814, 78, 137, 36, 879, 635, 152, 506, 167, 5, 22,
                452, 330, 862, 546, 234, 423, 300, 853, 684, 387, 577, 568, 647, 615, 393, 269, 637, 474, 699, 842, 138,
                549, 361, 532, 394, 689, 520, 597, 155, 591, 520, 150, 373, 808, 926, 417, 672, 9, 787, 757, 51, 278,
                479, 788, 143, 193, 459, 920, 175, 511, 851, 896, 959, 163, 629, 370, 751, 111, 999, 717, 442, 417, 171,
                394, 908, 411, 84, 528, 422, 951, 452, 239, 536, 212, 111, 32, 568, 712, 67, 852, 690, 164, 246, 421,
                207, 105, 74, 728, 524, 582, 801, 172, 497, 850, 442, 607, 439, 83, 8, 990, 681, 543, 768, 62, 881, 506,
                55, 10, 477, 52, 626, 664, 13, 184, 443, 823, 373, 348, 30, 869, 226, 180, 496, 756, 528, 225, 341, 212,
                582, 565, 98, 701, 263, 536, 961, 463, 605, 270, 793, 295, 443, 22, 955, 853, 700, 193, 735, 667, 222,
                920, 947, 951, 725, 995, 293, 401, 212, 2, 875, 558, 755, 130, 596, 87, 160, 649, 721, 311, 282, 438,
                921, 83, 669, 801, 721, 323, 628, 225, 827, 154, 80, 176, 368, 945, 381, 81, 707, 203, 300, 266, 113,
                446, 176, 738, 739, 892, 85, 239, 306, 657, 52, 999, 949, 230, 576, 320, 227, 343 };
        System.out.println(t1.solve(A, B)); // 39

    }
}
