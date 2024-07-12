import java.util.*;


public class Main {
    public static void main(String[] args) {

        // 소개페이지
        Scanner sc = new Scanner(System.in);
        String fairy = "\uD83E\uDDDA\u200D";
        System.out.printf("%s : 용사님 어서오세요!\n", fairy);
        System.out.printf("%s : 용사님의 이름을 알려주세요!\n", fairy);
        //인수 없으면 print
        System.out.print("내 이름 : ");
        String heroName = sc.nextLine();
        System.out.printf("%s : %s, 마왕군들이 우리 왕국에 쳐들어오고 있어요! 마왕군을 물리쳐주세요!\n\n\n", fairy, heroName);

        Random rd = new Random(System.currentTimeMillis());
        int heroHP = 100; //최대치
        int heroPotion = 3;
        boolean isHeroMonsterKillCountUnderFour = true;
        int heroMonsterKillCount = 0;
        int heroDamageSeed = 25;


        String enemyIncounterAnnounce =
                //인텔리제이 텍스트블록 처리
                """
                    ========================================
                    \uD83D\uDEA8\uD83D\uDEA8 %s 이(가) 나타났습니다.\uD83D\uDEA8\uD83D\uDEA8
                    %s 의 체력: %d (최대치 100)
                    %s 의 체력: %d
                    ========================================
                """;
        String[] enemyNames = {"벌레\uD83D\uDC1B", "닭\uD83D\uDC13","개\uD83D\uDC15","고블린\uD83D\uDC7A","마왕\uD83D\uDC79"};
        int[] enemyHPs = {5,15,23,40,110};
        int[] enemyDamageSeed = {2,3,5,9,30};
        // 리팩토링으로 자료구조 변경

        boolean isAdventure = true;
        while (isAdventure) {
            while (isHeroMonsterKillCountUnderFour) {
                //1~5까지 랜덤값 출력
                int enemyIncount = rd.nextInt(5);
                // 적 등장
                int enemyHP = enemyHPs[enemyIncount];
                switch (enemyIncount) {
                    //                ctrl + r (단어 바꾸기)
                    //                ctrl + f (단어로 검색)
                    //                ctrl + shift + f (프로젝트내 단어전체검색)
                    //                ctrl + shift + r (프로젝트내 단어전체바꾸기)
                    //                출처: https://baekh-93.tistory.com/33 [기초공사:티스토리]
                    case 0:
                        System.out.println(String.format(enemyIncounterAnnounce, enemyNames[enemyIncount], heroName, heroHP, enemyNames[enemyIncount], enemyHPs[enemyIncount]));
                        break;
                    case 1:
                        System.out.println(String.format(enemyIncounterAnnounce, enemyNames[enemyIncount], heroName, heroHP, enemyNames[enemyIncount], enemyHPs[enemyIncount]));
                        break;
                    case 2:
                        System.out.println(String.format(enemyIncounterAnnounce, enemyNames[enemyIncount], heroName, heroHP, enemyNames[enemyIncount], enemyHPs[enemyIncount]));
                        break;
                    case 3:
                        System.out.println(String.format(enemyIncounterAnnounce, enemyNames[enemyIncount], heroName, heroHP, enemyNames[enemyIncount], enemyHPs[enemyIncount]));
                        break;
                    case 4:
                        System.out.println("\uD83D\uDC7F\uD83D\uDC7F\uD83D\uDC7F 우리 마족들을 죽인 너는 나쁜놈이다 죽어라! \uD83D\uDC7F\uD83D\uDC7F\uD83D\uDC7F");
                        System.out.println(String.format(enemyIncounterAnnounce, enemyNames[enemyIncount], heroName, heroHP, enemyNames[enemyIncount], enemyHPs[enemyIncount]));
                        break;
                    default:
                        System.out.println("오류입니다!");
                }
                boolean isCounterFlag = true;
                String actionAnnounce =
                        """
                            액션을 선택해 주세요.
                            \t\t        1. 전투
                            \t\t        2. 포션 먹기\uD83E\uDDEA
                            \t\t        3. 도망\uD83C\uDFC3\u200D
                        """;
                String battleInformation =
                        """
                            ========================================
                            %s 의 체력: %d (최대치 100)
                            %s 의 체력: %d
                            ========================================
                        """;
                while (isCounterFlag) {

                    System.out.println(actionAnnounce);
                    int action = sc.nextInt();
                    if (!(1 <= action && action <= 3)) {
                        System.out.println("오류입니다! 다시 입력해주세요.");
                        continue;
                    }
                    switch (action) {
                        case 1:
                            int heroDamage = rd.nextInt(heroDamageSeed) + 1;
                            int enemyDamage = rd.nextInt(enemyDamageSeed[enemyIncount]) + 1;
                            enemyHP -= heroDamage;
                            heroHP -= enemyDamage;
                            System.out.println(String.format(battleInformation, heroName, heroHP, enemyNames[enemyIncount], enemyHP));
                            System.out.printf("> ⚔\uFE0F 적에게 %d만큼의 데미지를 주었습니다.\n", heroDamage);
                            System.out.printf("> \uD83E\uDE78 적에게 %d만큼의 데미지를 입었습니다.\n\n", enemyDamage);
                            break;
                        case 2:
                            if (0 < heroPotion) {
                                heroPotion--;
                                heroHP += 25;
                                // healPotionLimit
                                if(heroHP>100){
                                    heroHP=100;
                                }
                                System.out.printf("%s :️ 체력이 25만큼 회복되었습니다.⚡️\n", fairy);
                                System.out.printf("%s : 현재 %s님의 체력은 %d입니다. 남은 포션\uD83E\uDDEA의 수는 %d개 입니다.\n", fairy, heroName, heroHP, heroPotion);

                                break;
                            }
                            System.out.printf("\n%s :️ 남은 포션이 없습니다. 새로운 적을 물리쳐서 포션을 얻어보세요.️\n", fairy);
                            break;
                        case 3:
                            isCounterFlag = false;
                            break;
                        default:
                    }
                    if (heroHP <= 0) {
                        System.out.printf("\n%s : 용사님이 사망하셨습니다.\n", fairy);
                        System.out.printf("\n%s : 용사님의 모험이 종료되었습니다.\n", fairy);
                        heroMonsterKillCount =0;
                        isCounterFlag = false;
                        isHeroMonsterKillCountUnderFour = false;
                        isAdventure = false;
                    }
                    if (enemyHP <= 0) {
                        //마왕을 죽였다!
                        if(enemyIncount==4){
                            System.out.println("\n\n \uD83D\uDD4A\uFE0F\uD83D\uDD4A\uFE0F 축하드립니다! 마왕을 죽이셨습니다. 세상이 조금 평화로워졌을지도 모릅니다? \uD83D\uDD4A\uFE0F\uD83D\uDD4A\uFE0F \n\n");
                        }
                        heroMonsterKillCount++;
                        if(heroMonsterKillCount>=4){
                            isCounterFlag = false;
                            isHeroMonsterKillCountUnderFour = false;
                            System.out.println("\n✨✨최종 승리✨✨\n");
                            continue;
                        }
                        int potionDrop = rd.nextInt(2);
                        if (potionDrop == 1) {
                            System.out.printf("\n \uD83D\uDCE3 : %s 이(가) 포션을 남겼습니다!\n", enemyNames[enemyIncount]);
                            heroPotion++;
                            System.out.printf("%s : 현재 %s님에게 남은 포션의 개수는 %d개 입니다.\n", fairy, heroName, heroPotion);
                        }

                        //도망시 인카운터 다시들어감
                        //choiceContinue
                        boolean isContinueChoice = false;
                        while (!isContinueChoice) {
                            System.out.printf(
                                    """
                                        %s : 계속 모험을 하시겠습니까?
                                        \t\t 1. 모험 계속 하기
                                        \t\t 2. 모험 그만 하기\uD83C\uDF33
                                    """, fairy);
                            int choiceContinue = sc.nextInt();
                            if (!(1 <= choiceContinue && choiceContinue <= 2)) {
                                System.out.println("오류입니다! 다시 입력해주세요.");
                                continue;
                            }
                            switch (choiceContinue) {
                                case 1:
                                    isCounterFlag = false;
                                    isContinueChoice = true;

                                    break;
                                case 2:
                                    isHeroMonsterKillCountUnderFour = false;
                                    isCounterFlag = false;
                                    isContinueChoice = true;
                                    break;
                            }
                        }
                    }
                }
            }

            boolean isFinishGameChoice = false;
            while (!isFinishGameChoice) {
                System.out.printf(
                        """
                            %s : 게임을 끝내시겠습니까?
                            \t\t 1. 게임 계속 하기
                            \t\t 2. 게임 그만 하기\uD83C\uDF33
                        """, fairy);
                int choiceFinishGame = sc.nextInt();
                if (!(1 <= choiceFinishGame && choiceFinishGame <= 2)) {
                    System.out.println("오류입니다! 다시 입력해주세요.");
                    continue;
                }
                switch (choiceFinishGame) {
                    case 1:
                        heroHP = 100;
                        heroPotion = 3;
                        heroMonsterKillCount = 0;
                        isAdventure = true;
                        isHeroMonsterKillCountUnderFour = true;
                        isFinishGameChoice = true;
                        break;
                    case 2:
//                        이미 모험 계속하기, 사망, 4킬 시점에서 false 지정됨, 필요없음
//                        isHeroMonsterKillCountUnderFour = false;
                        isFinishGameChoice = true;
                        isAdventure = false;
                        break;
                }
            }
        }
        System.out.printf("\n%s : 게임이 종료되었습니다.\n", fairy);
        sc.close();
    }
    //코드 구조 변경 및 변수명 재정립 등 리팩토링 필요.
}

