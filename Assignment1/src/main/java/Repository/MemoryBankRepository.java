import Data.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryBankRepository {
    private static HashMap<Long, Member> bank = new HashMap<>();
    private static Long id = 0L;
    public void join(Member member) {
        member.setId(id++);
        bank.put(member.getId(), member);
    }
    public List<Member> findAll(){
        return new ArrayList<>(bank.values());
    }
}
