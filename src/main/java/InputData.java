import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class InputData {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner scaner= new Scanner(System.in);
        String timeStamp = null;
        System.out.print("Please enter from ");

        timeStamp = scaner.nextLine();

        System.out.print("Please enter to ");

        String timeStampTo = scaner.nextLine();


        List<String> timestams = new ArrayList<String>();
        timestams.add(timeStamp);
        timestams.add(timeStampTo);

        StringBuilder stringBuilder = new StringBuilder();


        for (String tmp : timestams) {


            ParseInputText parseInputText = new ParseInputText();
            String timeStampForBecoen = parseInputText.getParseData(tmp);

            SendGet sendGet = new SendGet();
            String rs = sendGet.sendGet(timeStampForBecoen);
            System.out.println("RS " + rs);


            stringBuilder.append(rs);

        }
        String response = stringBuilder.toString();
        System.out.println("FINAL RESPONSE " + response);

            ShowResult showResult = new ShowResult();
            showResult.getResponse(response);


        }
    }
