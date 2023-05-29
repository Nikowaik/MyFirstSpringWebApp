package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Award;
import firstwebjavaproject.javawebproject.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    private AwardRepository  awardRepository;
    @Override
    public void save(Award award) {
        awardRepository.save(award);
    }
}
