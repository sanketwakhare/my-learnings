import java.util.Arrays;

public class MaxScoreFromPerformingMultiplicationOperation {

    public static void main(String[] args) {
        MaxScoreFromPerformingMultiplicationOperation obj = new MaxScoreFromPerformingMultiplicationOperation();
        {
            int[] nums = new int[]{1, 2, 3};
            int[] multipliers = new int[]{3, 2, 1};
            System.out.println(obj.maximumScore(nums, multipliers)); // 14
        }
        {
            int[] nums = new int[]{-5, -3, -3, -2, 7, 1};
            int[] multipliers = new int[]{-10, -5, 3, 4, 6};
            System.out.println(obj.maximumScore(nums, multipliers)); // 102
        }
        {
            int[] nums = new int[]{-947, 897, 328, -467, 14, -918, -858, -701, -518, -997, 22, 259, -4, 968, 947, 582, -449, 895, -121, -403, 633, 490, 64, 543, -396, -997, 841, -398, 247, 297, -147, -708, 804, -199, -765, -547, -599, 406, -223, -11, 663, 746, -365, -859, 256, -25, 919, -334, 490, -511, 865, -139, -968, 961, -793, 451, 317, 645, -294, 240, -312, -822, 961, -572, 309, 579, 161, 780, 525, -622, -511, 423, 946, -28, -199, 822, -123, -316, -913, 113, -458, -428, -414, 49, 922, 722, -854, 323, -219, 581, 302, 124, 164, 31, 727, 186, 308, -936, -937, -862, 939, 213, 966, -74, -76, -1, 521, 777, -966, 454, -199, 526, -895, 447, -749, -518, -639, 849, -771, 979, -760, -763, -601, -201, 40, -911, 207, 890, -942, -352, 700, 267, 830, -396, 536, 877, -896, -687, 262, -60, -373, -373, 526};
            int[] multipliers = new int[]{864, 849, 586, 769, 309, -413, 318, 652, 883, -690, 796, 251, -648, 433, 1000, -969, 422, 194, -785, -242, -118, 69, 187, -925, -418, -556, 88, -399, -619, -383, -188, 206, -793, -9, 738, -587, 878, 360, 640, 318, -399, -366, 365, -291, -75, -451, -674, -199, 177, 862, 1, 11, 390, -52, -101, 127, -354, -717, -717, 180, 655, 817, -898, 28, -641, -35, -563, -737, 283, -223, -322, -59, 955, 172, 230, 512, -205, -180, 899, 169, -663, -253, 270, 651, 168, 417, 613, -443, 980, -189, 417, 372, -891, -272, 993, -877, 906, 680, -630, -328, -873, -811, 78, -667, -2, 190, -773, 878, 529, 620, -951, -687, 314, -989, -48, -601, -950, 31, -789, -663, -480, 750, -872, -358, 529, -426, -111, 517, 750, -536, -673, 370};
            System.out.println(obj.maximumScore(nums, multipliers)); // 32383191
        }
        {
            int[] nums = new int[]{161, 193, -625, 49, -201, -601, 898, -257, 402, -763, 851, 149, 368, -146, -51, 813, -792, -520, -506, -752, 795, -900, 917, 517, 496, -835, 319, -90, 100, 782, 269, 516, 23, -634, -654, 765, -165, 179, -336, 956, -120, -542, -908, -819, 875, 714, 449, -45, -998, 898, 182, -524, 224, 153, 98, 646, -412, 696, 759, -958, 258, -831, 386, -106, -13, -843, 630, -282, 979, 352, -83, 129, 307, -240, -710, 152, -670, -777, 304, 194, -175, 334, -616, -744, 925, -318, 902, 70, 166, 173, 887, 107, 481, 957, 867, -59, -877, 771, 335, 341, -340, 963, -853, 421, -187, -261, 681, -553, -861, -736, -565, 476, -96, -575, 487, -72, -3, -214, 190, -337, 259, -285, 18, 335, 831, 246, -30, -791, -629, 97, -314, -108, -215, -130, -652, -436, 547, 253, 214, -677, 123, -403, -580, -191, 641, 569, -114, -25, -389, 538, 487, -971, -728, -302, 679, 451, 58, 2, 370, -331, 997, 14, -872, -273, -197, 79, -574, 405, -556, -884, 482, -300, -865, -149, -141, -149, -548, -600, 361, -381, 551, -915, -261, -385, -64, 290, -4, -73, 957, 393, 669, -344, 433, 810, 523, 106, -3, -240, 398, 287, 695, -258, -889, -342, 676, -944, 865, -167, 207, -102, -191, 744, 732, -900, -572, 648, 759, 898, -539, 368, -879, 252, 353, -344, -642, -200, 15, 673, -828, -439, 904, -178, -178, 923, -859, -383, 199, -535, 51, -221, 550, -844, 464, 364, -447, 249, 521, 159, 669, -269, -813, 184, -260, -922, -530, -707, 91, 80, -878, -419, 390, 921, -924, 446, 763, -870, -928, -753, -119, -457, -965, -336, 660, -990, 614, 237, 93, 691, -610, 683, 971, -216, -319, 638, -72, -148, -712, -726, 231, -536, 602, 1, -379, 45, 46, 992, 455, -714, -261, -599, 114, 44, -111, -111, 446, 293, 702, -893, -111, -740, 987, 162, -26, -74, 812, -413, 833, 282, -663, 749, 767, -777, 715, -453, -835, 452, -241, 139, 304, -384, -753, 526, 458, 543, -586, 95, -982, 371, -64, 247, 502, -248, -742, -164, -648, -852, 762, -198, -814, -694, 128, 557, 169, -525, 806, -70, -48, 80, 506, -330, 904, -178, 557, -772, 931, 670, -677, 714, 497, 773, -408, -784, 982, 959, -943, 701, 675, 233, -434, -732, -153, 800, -568, 615, -895, -749, 568, -116, -637, 493, -116, -312, 909, -485, 432, 775, 250, 579, 334, 781, 6, -95, 738, 377, 332, 384, -131, -793, -538, -830, 520, -453, -946, -35, -723, 654, -688, -781, 370, 115, 979, -67, 408, -321, 480, -251, 669, -698, 958, 136, -548, -21, 821, 413, -783, -407, 435, -259, 376, 368, 35, 461, 715, 852, -548, 621, -147, -344, 914, 251, -204, -361, 579, -316, -165, 528, -870, -690, -416, -879, -19, 292, -219, 794, -679, -454, -423, 293, 374, -486, -818, -336, -97, 696, -18, -11, 996, 525, -509, -790, 204, 852, -956, 761, 49, 473, -859, -310, 285, -29, -835, 31, 634, -136, -358, -634, -107, 995, -61, -789, -827, -298, 533, -520, -304, 33, 262, -662, -943, 644, -355, 860, -477, -780, 335, -948, 462, 517, 159, 799, -606, 270, -974, 88, -691, -214, 946, 670, 109, 937, -86, -882, -907, 240, 451, 508, 481, -454, -428, 763, 803, 468, 592, 932, -758, -25, 881, -400, 574, 682, 372, -751, 919, -254, 747, 772, -740, -947, -902, -997, -762, 679, 101, 290, -199, -314, 63, 205, -884, -492, -750, -511, -755, 234, 347, 976, 439, 539, -854, -559, -995, 256, -688, 529, 687, 735, 587, 267, 169, -367, 550, -645, 583, -587, 734, 485, -649, -697, -873, -130, -539, 32, -139, -408, 453, -204, 1, 985, -668, -726, -952, 460, -83, 985, 87, 656, -479, -152, -688, 442, -85, -33, -685, 581, 840, 906, 418, 741, 109, 784, 902, -189, 65, 542, -252, 825, -689, -344, -466, -928, -782, 744, -994, 254, 421, 839, -622, 991, -757, -33, -90, 247, 483, 726, 113, 14, -45, 57, 112, -499, 407, 0, 885, 227, -107, -513, 531, -409, 175, -90, 663, -504, -781, -499, 688, 0, 745, -235, -500, -10, -806, 888, -226, -953, -407, 795, -173, -247, -550, -897, 331, -322, 533, 895, 600, -751, -901, -19, -544, -762, 46, 347, -744, 846, 225, 805, 159, 971, 431, 816, -41, 58, 331, 671, 329, 54, -31, 905, 226, 638, -299, 341, -635, -481, -175, -569, 236, -500, 201, -519, 224, 534, -339, -97, 684, -403, -775, 645, -117, -241, -557, -18, -166, 561, 8, -752, -373, -834, 739, -719, 99, -321, -926, -334, -730, -201, -942, 928, -529, 948, -167, -981, -389, -478, 783, 316, -753, -411, 7, 26, -223, -115, 762, 345, -639, 40, -76, -767, 875, 937, 615, 729, -986, 642, -6, -39, -496, 140, 993, 480, 871, -181, -931, 699, 605, 265, -241, -645, 889, -522, -863, -907, 177, 166, 571, -307, 211, 590, 982, -165, -258, 188, 182, 723, 637, 526, 607, 847, -90, -406, -797, 138, 615, 872, -657, -561, 181, -831, -782, 372, -865, 208, -347, -950, -248, -406, -812, 684, -594, 69, -720, 889, 975, -909, 794, 698, 74, 766, 267, 545, -317, 886, -892, 47, -804, -705, -764, -363, -504, -50, 318, 988, 14, -625, 18, -985, -216, 302, -3, -749, 219, 475, -177, 373, -274, 379, 437, 583, -368, 309, 897, -453, 737, 931, 358, -826, 957, -344, -602, 956, -459, 793, 350, 717, -628, 92, -403, 37, 479, -85, 715, -685, -243, -746, -145, 509, -689, 109, -684, 414, -249, -714, 758, 676, 898, -35, 314, 429, 878, -378, 313, -997, 814, -406, 432, 105, 315, -931, -879, -253, 927, 607, 581, -876, 467, -309, -821, -407, 626, 441, 459, 867, 779, 228, -924, -49, 878, -646, 149, 150, -327, -159, 103, 732, 172, 286, -993, -378, -221, 544, 702, 244, -330, 60, -743, -898, 173, -901, -104, -195, 903, -383, -997, 360, 448, 866, 447, 445, 311, -764, -322, 45, -727, -516, 521, -484, -751, 908, 628, 397, 44, -417, 708, 775, -241, 127, 810, 959, 313, -996, 651, -175, -564, 785, -354, -483, 922, -563, 733, -983, 353, 896, -380, -590, -518, -156, -22, 899, 295, -949, 5, -643, -356, -278, 755, 132, -698, -365, -798, 989, -126, -332, 998, -203, -210, -275, -471, 581, -88, -973, 938, -229, 765, 149, -135, 443, -360, 175, 160, 875, -398, 397, -981, 910, 523, -809, -20, -917, 983, 463, 429, 1000, 961, 656, 948, 654, -838, -812, 630, -36, 833, 456, -198, 279, 491, 224, 324, 979, -960, -155, -896, -255, -269, 813, -700, 413, 765, 433, 656, -447, -61, -461, -450, -768, 318, -855, 668, 110, -871, 354, 563, -934, 935, -677, -721, 93, -911, -420, -941, 898, -280, -433, 19, -279, 56, -613, 326, 859, 791, 367, 722, 71, -353, -23, 421, -986, -424, 426, 457, -485, -894, -937, -980, -277, 581, -299, 726, 48, -476, -509, 622, 21, 497, -805, -531, 98, 259, 578, 520, -978, -236, -453, -722, 827, 48, 835, -524, -977, 640, -231, 887, 451, -224, 810, -250, 444, 921, -721, -744, -920, -58, 110, -5, -967, -107, -399, -608, -29, -30, -998, -965, 148, -962, -453, 953, -236, -352, -712, 273, 455, -621, -453, -964, 37, -601, -928, -639, -504, 256, -649, 657, -587, -659, 475, -678, -371, -982, -144, 392, -901, -795, -633, 522, -179, -149, 480, -19, -900, -301, -961, -540, -854, 261, 678, -31, -145, 459, 363, -537, 797, 772, -279, 504, -632, 653, -226, 791, 745, -669, -642, -914, 340, 299, 552, -458, 259, 159, -683, 49, -948, -597, 606, -492, 180, -411, -112, -552, 14, 899, -221, 850, -722, 836, -709, 70, -191, -531, 218, -480, -313, -147, -758, -647, -871, -513, 822, 950, -729, 276, 768, -936, -74, -825, 290, -136, 145, 584, -421, 372, 22, -151, 349, 749, -317, -857, 401, -269, 469, 810, -176, 123, -473, -190, 577, -70, -625, 230, -384, 99, -436, -943, 991, -594, -715, -91, -260, 385, -351, 154, -425, -591, 973, 577, -758, 796, 474, 198, 382, -192, 258, -650, -466, 790, 695, 608, -58, -623, 209, -674, -536, 693, 734, 419, 154, 466, 834, 99, 655, 773, -643, 593, 310, -342, -842, 949, -311, -737, 519, -365, -280, -129, 606, 178, 265, -305, 819, -216, -884, -374, 580, -69, -793, 63, 217, -458, -654, 831, -833, -60, 465, 23, 578, 964, -616, -671, -345, -724, 143, -72, -254, 3, 507, -354, -243, -674, 866, -701, -281, 907, 300, 237, 68, 235, 474, 83, 749, -568, 213, 517, -280, 190, 965, 862, -260, 2, 651, -567, -389, -878, -612, -62, 78, -960, -318, -811, 621, -590, -789, 866, -619, -242, 824, -241, 487, -72, 777, 217, 675, 241, 673};
            int[] multipliers = new int[]{-266, 336, 321, -767, -221, 959, 813, 411, -956, 82, -4, 449, -458, -260, -4, -563, 712, 295, -242, -967, 434, 318, -821, 994, 26, -437, 242, -667, -810, 952, -961, -349, -850, -30, -253, 231, -552, 823, 286, 845, -89, 311, -21, -806, -374, 735, -879, -551, 968, -143, -426, -448, -583, 648, -485, -350, 175, 295, -641, -902, -912, 308, -75, -976, -24, 960, -295, 116, -396, 715, -326, 491, -298, -990, 219, 528, 306, -619, -670, -916, -576, 802, -485, -624, 988, 349, -342, 902, 603, -685, -362, 11, -877, -735, -263, 803, -289, 302, -778, 786, -887, 752, -742, -682, 997, 272, 12, -342, 724, -886, -477, 816, -547, -938, -883, 299, 687, 432, 463, 337, -330, -242, -165, 941, 870, -961, -621, 679, -215, -604, -546, 959, -238, -52, -136, -30, -792, 96, -307, -404, 42, 170, 712, 498, 844, -331, -557, -614, -348, 31, -224, 637, 139, -770, -45, -252, -714, -963, -486, 805, -621, 339, -918, 372, 628, 417, 680, 442, -220, 110, -330, -133, 371, -335, 79, -881, 366, 126, -621, -876, 829, 726, 738, 646, -206, -504, -195, 932, -63, 399, -415, 486, 287, -833, 791, -717, 376, -305, 162, -170, -299, 736, -7, 856, -820, -574, 749, -241, -597, 529, -458, 487, -662, 375, -381, -549, 22, -756, -230, 314, 159, 555, 134, 282, -707, -800, 586, 89, 243, -477, -187, 941, -306, -413, -525, 842, 470, 38, 414, 454, 102, 982, -682, -717, 249, -502, 63, -431, 730, 546, -778, -60, -365, -989, -504, -80, 120, -723, 745, 571, 922, 99, 152, -727, -699, 45, 989, 449, -50, -522, 930, 664, 385, 517, -500, 949, 589, 88, -366, 967, -557, -618, -19, -901, 308, 693, 580, -638, 549, -285, 641, 62, 367, 175, 837, 87, -884, -55, 859, 649, 566, 46, 871, 923, -444, 625, 938, -553, -95, -364, -334, -276, 779, 768, -777, 181, -129, 659, 594, 890, -649, 720, -623, 619, -775, 42, -716, 469, 534, -690, 413, 724, -642, 607, 613, 955, 566, 601, -812, 44, 104, 87, -504, 772, -694, -102, 650, 471, -49, -723, 572, 113, -466, 375, 978, 413, 645, 202, 335, -440, -890, 907, 240, 835, 176, -263, -315, -656, -99, 74, 214, -995, -627, -828, 64, -713, 288, -829, 247, -451, -798, 456, 946, -390, -807, -582, -12, -709, -147, -928, -965, 724, 673, 217, 392, -717, 931, -631, 45, 592, 824, 438, 428, 65, -132, 496, -227, 738, -157, -499, 512, 679, -344, -130, -514, 297, -776, -457, -601, 208, -632, -658, 824, -649, 781, 865, -657, -69, -479, 537, 687, -351, 540, 508, 200, 887, 501, 608, -969, -382, -873, -46, -247, -985, -907, -770, 492, -290, -489, 18, -70, 580, -275, -478, -195, -343, 173, 908, 976, 783, 5, -773, 290, 252, -402, -88, 736, 718, 390, -888, -790, 865, -961, 962, 963, 814, 810, 537, 171, -529, -503, 499, 803, 788, -806, -691, -580, 874, 990, -988, -117, 639, -645, 731, -456, 685, 621, 299, -908, -566, 121, -360, -918, -577, -156, 318, -706, 424, 354, 589, 85, -795, 125, 17, -193, 337, 709, 124, 908, 47, -789, 353, 292, 331, 276, -384, 230, 248, 855, 139, -13, 536, 200, -805, 860, -692, -502, -915, -281, -827, -313, 746, 823, -399, 570, 995, -871, -319, -471, 165, 842, 430, 378, 238, 742, 975, -951, -721, -339, -15, -643, -982, -642, 749, -322, 210, 897, 845, 343, -418, 782, -250, -363, 302, -491, -36, -467, -378, 649, -878, 153, -954, -248, -187, -949, 139, 270, -995, 56, 111, -122, 62, -477, 892, 257, 229, -393, 824, -692, 365, -118, -81, 992, -471, -90, -503, 176, 867, 815, -841, 147, -462, 799, -808, 391, 710, 110, -569, -350, -806, 878, -533, 697, 86, 792, -709, -536, -675, -300, -128, -672, 515, -894, -722, 579, -688, 789, 216, -444, -500, -573, -481, 878, -363, -992, 769, 129, 248, 92, 554, 219, -539, 708, 672, 185, 917, -833, 2, -670, -827, -415, 741, -944, -524, -418, -988, 831, -886, 227, 154, 711, 996, -491, 426, -442, -313, -3, -710, 607, -621, -401, -694, 398, -328, -180, 239, 121, -512, -469, -518, -123, -39, 440, 282, 478, 126, -415, -176, 104, 518, -533, 187, 26, -145, -613, 470, -462, 477, -388, 776, -852, 179, 146, 687, 313, 978, 231, -951, 554, 944, 578, -914, -478, -394, -379, -332, 947, -531, 779, 830, 302, 881, -644, 939, 450, 226, 500, 709, -874, -942, 847, 549, 233, -10, 954, -248, 153, 570, -293, 692, -415, -774, 655, -176, -300, -931, -861, -357, 277, -105, -622, 462, -109, -32, -436, -656, -850, 346, 827, 27, -608, 626, -737, 771, -831, 288, -406, -525, -312, 796, -862, -735, -140, -838, -804, 481, -846, -226, 510, -797, -567, 985, -561, 230, 689, 489, -409, -332, -551, 525, 3, 511, 657, 308, 454, 565, -327, -972, -161, -456, 576, 989, -670, -25, 736, -620, 898, 806, -276, 257, 546, -648, -169, 74, -464, 911, 725, 792, -576, -832, -534, -294, -25, -858, -317, 181, -865, -185, 826, -48, -507, -386, 185, -928, -191, 415, 357, 411, -655, -732, 924, -311, 207, 228, -723, 684, 154, -324, -619, 497};
            System.out.println(obj.maximumScore(nums, multipliers)); // 220364069
        }
        {
            int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] multipliers = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            System.out.println(obj.maximumScore(nums, multipliers)); // -1
        }
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        return tabulation(nums, multipliers);
    }

    public int maximumScore_recursive(int[] nums, int[] multipliers) {

        int[][] dp = new int[multipliers.length + 1][multipliers.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int score = f(0, 0, nums, multipliers, dp);
        System.out.println(Arrays.deepToString(dp));
        return score;
    }

    public int f(int numsIndex, int operation, int[] nums, int[] multipliers, int[][] dp) {

        if (operation == multipliers.length) {
            return 0;
        }
        if (dp[operation][numsIndex] != -1) return dp[operation][numsIndex];

        // choose from start
        int x = (multipliers[operation] * nums[numsIndex])
                + f(numsIndex + 1, operation + 1, nums, multipliers, dp);

        // choose from end
        int y = (multipliers[operation] * nums[nums.length - 1 - (operation - numsIndex)])
                + f(numsIndex, operation + 1, nums, multipliers, dp);

        return dp[operation][numsIndex] = Math.max(x, y);
    }

    public int tabulation(int[] nums, int[] multipliers) {
        // For Right Pointer
        int n = nums.length;
        // Number of Operations
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], 0);

        for (int mulIndex = m - 1; mulIndex >= 0; mulIndex--) {
            for (int numsIndex = mulIndex; numsIndex >= 0; numsIndex--) {
                dp[mulIndex][numsIndex] = Math.max(multipliers[mulIndex] * nums[numsIndex] + dp[mulIndex + 1][numsIndex + 1],
                        multipliers[mulIndex] * nums[n - 1 - (mulIndex - numsIndex)] + dp[mulIndex + 1][numsIndex]);
            }
        }
        return dp[0][0];
    }
}
