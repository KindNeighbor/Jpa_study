package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street1","1000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("보쌈");
            member.getFavoriteFoods().add("콜라");


            member.getAddressHistory().add(new AddressEntity("old12", "street2","200"));
            member.getAddressHistory().add(new AddressEntity("old23", "street3","300"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============start=============");
            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }

//            findMember.getHomeAddress().setCity("city");

//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity",a.getStreet(),a.getZipcode()));
//
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("초밥");



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
