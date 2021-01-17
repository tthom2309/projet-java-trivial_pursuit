package view;

/**
 * This class contains all the coordinate points for the board game and all the cursors
 * @author Thomas
 *
 */

public class CoordonneePlateau {

	//liste des coordonn�es x du plateau
	private static int plateauX[][]={
		{96*2,85*2,96*2,120*2,131*2,120*2},//0
		{96*2,96*2,120*2,120*2},//1
		{96*2,96*2,120*2,120*2},//2
		{96*2,96*2,120*2,120*2},//3
		{96*2,96*2,120*2,120*2},//4
		{96*2,96*2,120*2,120*2},//5
		{85*2,96*2,120*2,132*2,108*2},//6
		{131*2,120*2,129*2,140*2},//7
		{140*2,129*2,137*2,148*2},//8
		{148*2,137*2,146*2,157*2},//9
		{157*2,146*2,155*2,166*2},//10
		{166*2,155*2,163*2,174*2},//11
		{174*2,163*2,172*2,183*2},//12
		{120*2,131*2,141*2,130*2},//13
		{130*2,141*2,152*2,141*2},//14
		{141*2,152*2,162*2,151*2},//15
		{151*2,162*2,173*2,162*2},//16
		{162*2,173*2,183*2,172*2},//17
		{183*2,172*2,183*2,206*2,206*2},//18
		{183*2,183*2,206*2,206*2},//19
		{183*2,183*2,206*2,206*2},//20
		{183*2,183*2,206*2,206*2},//21
		{183*2,183*2,206*2,206*2},//22
		{183*2,183*2,206*2,206*2},//23
		{183*2,183*2,206*2,206*2},//24	
		{131*2,120*2,130*2,141*2},//25
		{141*2,130*2,141*2,152*2},//26
		{152*2,141*2,151*2,162*2},//27
		{162*2,151*2,162*2,173*2},//28
		{173*2,162*2,172*2,183*2},//29
		{183*2,172*2,183*2,206*2,206*2},//30
		{172*2,183*2,174*2,163*2},//31
		{163*2,174*2,166*2,155*2},//32
		{155*2,166*2,157*2,146*2},//33
		{146*2,157*2,148*2,137*2},//34
		{137*2,148*2,140*2,129*2},//35
		{129*2,140*2,131*2,120*2},//36
		{96*2,96*2,120*2,120*2},//37
		{96*2,96*2,120*2,120*2},//38
		{96*2,96*2,120*2,120*2},//39
		{96*2,96*2,120*2,120*2},//40
		{96*2,96*2,120*2,120*2},//41
		{120*2,131*2,108*2,85*2,96*2},//42
		{96*2,85*2,76*2,87*2},//43
		{87*2,76*2,68*2,79*2},//44
		{79*2,68*2,59*2,70*2},//45
		{70*2,59*2,50*2,61*2},//46
		{61*2,50*2,42*2,53*2},//47
		{53*2,42*2,33*2,44*2},//48
		{85*2,96*2,86*2,75*2},//49
		{75*2,86*2,75*2,64*2},//50
		{64*2,75*2,65*2,54*2},//51
		{54*2,65*2,54*2,43*2},//52
		{43*2,54*2,44*2,33*2},//53
		{44*2,33*2,10*2,10*2,33*2},//54
		{10*2,33*2,33*2,10*2},//55
		{10*2,33*2,33*2,10*2},//56
		{10*2,33*2,33*2,10*2},//57
		{10*2,33*2,33*2,10*2},//58
		{10*2,33*2,33*2,10*2},//59
		{10*2,33*2,33*2,10*2},//60
		{96*2,85*2,75*2,86*2},//61
		{86*2,75*2,64*2,75*2},//62
		{75*2,64*2,54*2,65*2},//63
		{65*2,54*2,43*2,54*2},//64
		{54*2,43*2,33*2,44*2},//65
		{33*2,10*2,10*2,33*2,44*2},//66
		{33*2,44*2,53*2,42*2},//67
		{42*2,53*2,61*2,50*2},//68
		{50*2,61*2,70*2,59*2},//69
		{59*2,70*2,79*2,68*2},//70
		{68*2,79*2,87*2,76*2},//71
		{76*2,87*2,96*2,85*2},//72
};

	//liste des coordonn�es y du plateau
	private static int plateauY[][]={
		{102*2,122*2,142*2,142*2,122*2,102*2},//0
		{90*2,102*2,102*2,90*2},//1
		{78*2,90*2,90*2,78*2},//2
		{66*2,78*2,78*2,66*2},//3
		{54*2,66*2,66*2,54*2},//4
		{42*2,54*2,54*2,42*2},//5
		{20*2,42*2,42*2,20*2,6*2},//6
		{20*2,42*2,47*2,25*2},//7
		{25*2,47*2,52*2,30*2},//8
		{30*2,52*2,57*2,35*2},//9
		{35*2,57*2,62*2,40*2},//10
		{40*2,62*2,67*2,45*2},//11
		{45*2,67*2,72*2,50*2},//12
		{102*2,122*2,116*2,96*2},//13
		{96*2,116*2,110*2,90*2},//14
		{90*2,110*2,104*2,84*2},//15
		{84*2,104*2,98*2,78*2},//16
		{78*2,98*2,92*2,72*2},//17
		{50*2,72*2,92*2,92*2,66*2},//18
		{92*2,102*2,102*2,92*2},//19
		{102*2,112*2,112*2,102*2},//20
		{112*2,122*2,122*2,112*2},//21
		{122*2,132*2,132*2,122*2},//22
		{132*2,142*2,142*2,132*2},//23
		{142*2,152*2,152*2,142*2},//24
		{122*2,142*2,148*2,128*2},//25
		{128*2,148*2,154*2,134*2},//26
		{134*2,154*2,160*2,140*2},//27
		{140*2,160*2,166*2,146*2},//28
		{146*2,166*2,172*2,152*2},//29
		{152*2,172*2,194*2,178*2,152*2},//30
		{172*2,194*2,199*2,177*2},//31
		{177*2,199*2,204*2,182*2},//32
		{182*2,204*2,209*2,187*2},//33
		{187*2,209*2,214*2,192*2},//34
		{192*2,214*2,219*2,197*2},//35
		{197*2,219*2,224*2,202*2},//36
		{142*2,154*2,154*2,142*2},//37
		{154*2,166*2,166*2,154*2},//38
		{166*2,178*2,178*2,166*2},//39
		{178*2,190*2,190*2,178*2},//40
		{190*2,202*2,202*2,190*2},//41
		{202*2,224*2,238*2,224*2,202*2},//42
		{202*2,224*2,219*2,197*2},//43
		{197*2,219*2,214*2,192*2},//44
		{192*2,214*2,209*2,187*2},//45
		{187*2,209*2,204*2,182*2},//46
		{182*2,204*2,199*2,177*2},//47
		{177*2,199*2,194*2,172*2},//48
		{122*2,142*2,148*2,128*2},//49
		{128*2,148*2,154*2,134*2},//50
		{134*2,154*2,160*2,140*2},//51
		{140*2,160*2,166*2,146*2},//52
		{146*2,166*2,172*2,152*2},//53
		{172*2,194*2,178*2,152*2,152*2},//54
		{152*2,152*2,142*2,142*2},//55
		{142*2,142*2,132*2,132*2},//56
		{132*2,132*2,122*2,122*2},//57
		{122*2,122*2,112*2,112*2},//58
		{112*2,112*2,102*2,102*2},//59
		{102*2,102*2,92*2,92*2},//60
		{102*2,122*2,116*2,96*2},//61
		{96*2,116*2,110*2,90*2},//62
		{90*2,110*2,104*2,84*2},//63
		{84*2,104*2,98*2,78*2},//64
		{78*2,98*2,92*2,72*2},//65
		{92*2,92*2,66*2,50*2,72*2},//66
		{50*2,72*2,67*2,45*2},//67
		{45*2,67*2,62*2,40*2},//68
		{40*2,62*2,57*2,35*2},//69
		{35*2,57*2,52*2,30*2},//70
		{30*2,52*2,47*2,25*2},//71
		{25*2,47*2,42*2,20*2},//72
		
};

	//liste des coordonn�es x de la forme centrale du plateau
	private static int caseDepX[][]={
		{96*2,108*2,120*2},
		{120*2,108*2,131*2},
		{131*2,108*2,120*2},
		{108*2,120*2,96*2},
		{96*2,108*2,85*2},
		{85*2,108*2,96*2}
};
	
	//liste des coordonn�es y de la forme centrale du plateau
	private static int caseDepY[][]={
		{102*2,122*2,102*2},
		{102*2,122*2,122*2},
		{122*2,122*2,142*2},
		{122*2,142*2,142*2},
		{142*2,122*2,122*2},
		{122*2,122*2,102*2},
};
	
	//correspond aux coordonn�es x des diff�rents curseurs possibles
	private static int curseurX[][]={
			{108*2,114*2,102*2},//0
			{108*2,114*2,102*2},//1
			{108*2,114*2,102*2},//2
			{108*2,114*2,102*2},//3
			{108*2,114*2,102*2},//4
			{108*2,114*2,102*2},//5
			{108*2,114*2,102*2},//6
			{130*2,136*2,124*2},//7
			{139*2,145*2,133*2},//8
			{147*2,153*2,141*2},//9
			{156*2,162*2,150*2},//10
			{165*2,171*2,159*2},//11
			{173*2,179*2,167*2},//12
			{131*2,137*2,125*2},//13
			{141*2,147*2,135*2},//14
			{152*2,158*2,146*2},//15
			{162*2,168*2,156*2},//16
			{173*2,179*2,167*2},//17
			{189*2,195*2,183*2},//18
			{195*2,201*2,189*2},//19
			{195*2,201*2,189*2},//20
			{195*2,201*2,189*2},//21
			{195*2,201*2,189*2},//22
			{195*2,201*2,189*2},//23
			{195*2,201*2,189*2},//24
			{131*2,137*2,125*2},//25
			{141*2,147*2,135*2},//26
			{152*2,158*2,146*2},//27
			{162*2,168*2,156*2},//28
			{173*2,179*2,167*2},//29
			{189*2,195*2,183*2},//30
			{173*2,179*2,167*2},//31
			{165*2,171*2,159*2},//32
			{156*2,162*2,150*2},//33
			{147*2,153*2,141*2},//34
			{139*2,145*2,133*2},//35
			{130*2,136*2,124*2},//36
			{108*2,114*2,102*2},//37
			{108*2,114*2,102*2},//38
			{108*2,114*2,102*2},//39
			{108*2,114*2,102*2},//40
			{108*2,114*2,102*2},//41
			{108*2,114*2,102*2},//42
			{86*2,92*2,80*2},//43
			{78*2,84*2,72*2},//44
			{69*2,75*2,63*2},//45
			{60*2,66*2,54*2},//46
			{52*2,58*2,46*2},//47
			{43*2,49*2,37*2},//48
			{86*2,91*2,80*2},//49
			{75*2,81*2,69*2},//50
			{65*2,71*2,59*2},//51
			{54*2,60*2,48*2},//52
			{44*2,50*2,38*2},//53
			{27*2,33*2,21*2},//54
			{22*2,28*2,16*2},//55
			{22*2,28*2,16*2},//56
			{22*2,28*2,16*2},//57
			{22*2,28*2,16*2},//58
			{22*2,28*2,16*2},//59
			{22*2,28*2,16*2},//60
			{86*2,91*2,80*2},//61
			{75*2,81*2,69*2},//62
			{65*2,71*2,59*2},//63
			{54*2,60*2,48*2},//64
			{44*2,50*2,38*2},//65
			{27*2,33*2,21*2},//66
			{43*2,49*2,37*2},//67
			{52*2,58*2,46*2},//68
			{60*2,66*2,54*2},//69
			{69*2,75*2,63*2},//70
			{78*2,84*2,72*2},//71
			{86*2,92*2,80*2},//72	
	};
	
	//correspond aux coordonn�es y des diff�rents curseurs possibles
	private static int curseurY[][]={
		{122*2,107*2,107*2},//0
		{96*2,81*2,81*2},//1
		{84*2,69*2,69*2},//2
		{72*2,57*2,57*2},//3
		{60*2,45*2,45*2},//4
		{48*2,33*2,33*2},//5
		{24*2,9*2,9*2},//6
		{34*2,19*2,19*2},//7
		{39*2,24*2,24*2},//8
		{44*2,29*2,29*2},//9
		{49*2,34*2,34*2},//10
		{54*2,39*2,39*2},//11
		{59*2,44*2,44*2},//12
		{109*2,94*2,94*2},//13
		{103*2,88*2,88*2},//14
		{97*2,82*2,82*2},//15
		{91*2,76*2,76*2},//16
		{85*2,70*2,70*2},//17
		{71*2,56*2,56*2},//18
		{97*2,82*2,82*2},//19
		{107*2,92*2,92*2},//20
		{117*2,102*2,102*2},//21
		{127*2,112*2,112*2},//22
		{137*2,122*2,122*2},//23
		{147*2,132*2,132*2},//24
		{135*2,120*2,120*2},//25
		{141*2,126*2,126*2},//26
		{147*2,132*2,132*2},//27
		{153*2,138*2,138*2},//28
		{159*2,144*2,144*2},//29
		{173*2,158*2,158*2},//30
		{186*2,171*2,171*2},//31
		{191*2,176*2,176*2},//32
		{196*2,181*2,181*2},//33
		{201*2,186*2,186*2},//34
		{206*2,191*2,191*2},//35
		{211*2,196*2,196*2},//36
		{148*2,133*2,133*2},//37
		{160*2,145*2,145*2},//38
		{172*2,157*2,157*2},//39
		{184*2,169*2,169*2},//40
		{196*2,181*2,181*2},//41
		{220*2,205*2,205*2},//42
		{211*2,196*2,196*2},//43
		{206*2,191*2,191*2},//44
		{201*2,186*2,186*2},//45
		{196*2,181*2,181*2},//46
		{191*2,176*2,176*2},//47
		{186*2,171*2,171*2},//48
		{135*2,120*2,120*2},//49
		{141*2,126*2,126*2},//50
		{147*2,132*2,132*2},//51
		{153*2,138*2,138*2},//52
		{159*2,144*2,144*2},//53
		{173*2,158*2,158*2},//54	
		{147*2,132*2,132*2},//55
		{137*2,122*2,122*2},//56
		{127*2,112*2,112*2},//57
		{117*2,102*2,102*2},//58
		{107*2,92*2,92*2},//59
		{97*2,82*2,82*2},//60
		{109*2,94*2,94*2},//61
		{103*2,88*2,88*2},//62
		{97*2,82*2,82*2},//63
		{91*2,76*2,76*2},//64
		{85*2,70*2,70*2},//65
		{71*2,56*2,56*2},//66
		{59*2,44*2,44*2},//67
		{54*2,39*2,39*2},//68
		{49*2,34*2,34*2},//69
		{44*2,29*2,29*2},//70
		{39*2,24*2,24*2},//71
		{34*2,19*2,19*2},//72
};

	
	public static int[][] getPlateauX() {
		return plateauX;
	}

	public static int[][] getPlateauY() {
		return plateauY;
	}

	public static int[][] getCaseDepX() {
		return caseDepX;
	}

	public static int[][] getCaseDepY() {
		return caseDepY;
	}

	public static int[][] getCurseurX() {
		return curseurX;
	}

	public static int[][] getCurseurY() {
		return curseurY;
	}
	
	
}