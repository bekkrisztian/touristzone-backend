package ro.touristzone.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.touristzone.model.Opinion;
import ro.touristzone.repository.OpinionRepository;
import ro.touristzone.service.OpinionService;

@Service
public class OpinionServiceImpl implements OpinionService {

	@Autowired
	OpinionRepository opinionRepository;

	// find all
	@Override
	public List<Opinion> getOpinionList() {
		return opinionRepository.findAll();
	}

	// get by id
	@Override
	public Opinion getOpinionById(Long id) {
		return opinionRepository.findById(id).get();
	}

	// save
	@Override
	public void saveOpinion(Opinion opinion) {
		opinionRepository.save(opinion);
	}

	// delete
	@Override
	public void deleteOpinion(Long id) {
		opinionRepository.deleteById(id);
	}
}