import java.util.Scanner;

public class CoffeeMethod implements CoffeeMethodInterface {
    Scanner sc = new Scanner(System.in);
    Remain remain = new Remain();
    RemainCoffee remainCoffee = new RemainCoffee();
    @Override
    public void buy() {
        try {
            System.out.println("어떤 커피를 구매하시겠습니까?");
            System.out.println("1. 에스프레소 4000원 | 2. 라떼 7000원 | 3. 카푸치노 6000원");
            int selectNum = Integer.parseInt(sc.nextLine());
            switch (selectNum) {
                case 1:
                    EspressoCheck();
                    break;
                case 2:
                    LatteCheck();
                    break;
                case 3:
                    CappuccinoCheck();
                    break;
                default:
                    System.out.println("1에서 3 중 하나를 입력해주세요");
            }
        } catch (NumberFormatException e){
            System.out.println("숫자를 입력해주세요");
            buy();
        }
    }
    @Override
    public void fill() {
        try {
            System.out.print("추가할 물의 양을 입력하세요 : ");
            int fillWater = Integer.parseInt(sc.nextLine());
            remain.setRemainWater(remain.getRemainWater() + fillWater);

            System.out.print("추가할 우유의 양을 입력하세요 : ");
            int fillMilk = Integer.parseInt(sc.nextLine());
            remain.setRemainMilk(remain.getRemainMilk() + fillMilk);

            System.out.print("추가할 원두의 양을 입력하세요 : ");
            int fillCoffeeBean = Integer.parseInt(sc.nextLine());
            remain.setRemainCoffeeBean(remain.getRemainCoffeeBean() + fillCoffeeBean);

            System.out.print("추가할 일회용 컵의 양을 입력하세요 : ");
            int fillCup = Integer.parseInt(sc.nextLine());
            remain.setRemainCup(remain.getRemainCup() + fillCup);
        } catch(NumberFormatException e){
            System.out.println("숫자를 입력해주세요");
        }
    }

    @Override
    public void take() {
        try{
            System.out.print("가져갈 돈을 입력해주세요 : ");
            int money = Integer.parseInt(sc.nextLine());
            if (remain.getRemainMoney() < money) {
                System.out.println("잔고가 부족합니다");
            } else {
                remain.setRemainMoney(remain.getRemainMoney() - money);
            }
        } catch (NumberFormatException e){
            System.out.println("숫자를 입력해주세요");
        }
    }

    @Override
    public void now(){
        System.out.println("--------------- 현재 커피머신 상태 ---------------");
        System.out.println("---------------  남은 재료와 돈  ----------------");
        System.out.println("물 : "+remain.getRemainWater()+"ml");
        System.out.println("우유 : "+ remain.getRemainMilk() +"ml");
        System.out.println("원두 : "+ remain.getRemainCoffeeBean() +"g");
        System.out.println("일회용 컵 : "+ remain.getRemainCup() +"개");
        System.out.println("돈 : "+remain.getRemainMoney()+"원");
    }

    @Override
    public void select() {
        try {
            int selectNum;
            boolean isRun = true;
            while (isRun) {
                now();
                System.out.println("옵션을 선택하세요");
                System.out.println("1. 구매 2. 채우기 3. 가져가기 4. 종료");
                selectNum = Integer.parseInt(sc.nextLine());
                switch (selectNum) {
                    case 1:
                        buy();
                        break;
                    case 2:
                        fill();
                        break;
                    case 3:
                        take();
                        break;
                    case 4:
                        System.out.println("커피머신이 종료되었습니다");
                        isRun = false;
                        break;
                    default:
                        System.out.println("1에서 4중 하나를 선택해주세요");
                        break;
                }
            }
        }catch (NumberFormatException e){
            System.out.println("숫자를 입력해주세요");
            select();
        }
    }
    @Override
    public void EspressoCheck(){
        if(remain.getRemainWater() < remainCoffee.EspressoWater || remain.getRemainCoffeeBean() < remainCoffee.EspressoCoffeeBean) {
            if (remain.getRemainWater() < remainCoffee.EspressoWater) {
                System.out.println("물이 부족합니다");
            }
            if (remain.getRemainCoffeeBean() < remainCoffee.EspressoCoffeeBean) {
                System.out.println("원두가 부족합니다");
            }
        }
        else {
            System.out.println("에스프레소를 구매하셨습니다 맛있게 드세요");
            remain.setRemainWater(remain.getRemainWater()-remainCoffee.EspressoWater);
            remain.setRemainCoffeeBean(remain.getRemainCoffeeBean()-remainCoffee.EspressoCoffeeBean);
            remain.setRemainCup(remain.getRemainCup()-remainCoffee.cup);
            remain.setRemainMoney(remain.getRemainMoney()+remainCoffee.EspressoMoney);
        }
    }
    public void LatteCheck(){
        if(remain.getRemainWater() < remainCoffee.LatteWater || remain.getRemainCoffeeBean() < remainCoffee.LatteMilk || remain.getRemainCoffeeBean() < remainCoffee.LatteCoffeeBean) {
            if (remain.getRemainWater() < remainCoffee.LatteWater) {
                System.out.println("물이 부족합니다");
            }
            if (remain.getRemainMilk() < remainCoffee.LatteMilk) {
                System.out.println("우유가 부족합니다");
            }
            if (remain.getRemainCoffeeBean() < remainCoffee.LatteCoffeeBean) {
                System.out.println("원두가 부족합니다");
            }
        }
        else {
            System.out.println("라떼를 구매하셨습니다 맛있게 드세요");
            remain.setRemainWater(remain.getRemainWater()-remainCoffee.LatteWater);
            remain.setRemainMilk(remain.getRemainMilk()-remainCoffee.LatteMilk);
            remain.setRemainCoffeeBean(remain.getRemainCoffeeBean()-remainCoffee.LatteCoffeeBean);
            remain.setRemainCup(remain.getRemainCup()-remainCoffee.cup);
            remain.setRemainMoney(remain.getRemainMoney()+remainCoffee.LatteMoney);
        }
    }
    public void CappuccinoCheck(){
        if(remain.getRemainWater() < remainCoffee.CappuccinoWater || remain.getRemainCoffeeBean() < remainCoffee.CappuccinoMilk || remain.getRemainCoffeeBean() < remainCoffee.CappuccinoCoffeeBean) {
            if (remain.getRemainWater() < remainCoffee.CappuccinoWater) {
                System.out.println("물이 부족합니다");
            }
            if (remain.getRemainMilk() < remainCoffee.CappuccinoMilk) {
                System.out.println("우유가 부족합니다");
            }
            if (remain.getRemainCoffeeBean() < remainCoffee.CappuccinoCoffeeBean) {
                System.out.println("원두가 부족합니다");
            }
        }
        else {
            System.out.println("카푸치노를 구매하셨습니다 맛있게 드세요");
            remain.setRemainWater(remain.getRemainWater()-remainCoffee.CappuccinoWater);
            remain.setRemainMilk(remain.getRemainMilk()-remainCoffee.CappuccinoMilk);
            remain.setRemainCoffeeBean(remain.getRemainCoffeeBean()-remainCoffee.CappuccinoCoffeeBean);
            remain.setRemainCup(remain.getRemainCup()-remainCoffee.cup);
            remain.setRemainMoney(remain.getRemainMoney()+remainCoffee.CappuccinoMoney);
        }
    }
}