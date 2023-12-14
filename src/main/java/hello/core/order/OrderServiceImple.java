package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.dicount.discountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImple implements OrderService{
    private final MemberRepository memberRepo;

    //추상 + 구현체 둘다 의존 결국 DIP 위반
//    private final discountPolicy discount = new fixDiscountPolicy();
    //단순히 이렇게하면 망가짐. 널 할당.  >> 의존성 주입을 통해 해결
    //관심사의 분리
    private final discountPolicy discount;

    //세터 주입
//    @Autowired
//    public void setMemberRepo(MemberRepository memberRepo) {
//        this.memberRepo = memberRepo;
//    }
//
//    @Autowired
//    public void setDiscount(discountPolicy discount) {
//        this.discount = discount;
//    }


    @Override
    public Order createOrder(long memberId, String itemName, int itemPrice) {
        Member member = memberRepo.findById(memberId);
        int discountPrice = discount.discount(member, itemPrice);
//       철저하게 지킨 OCP

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
