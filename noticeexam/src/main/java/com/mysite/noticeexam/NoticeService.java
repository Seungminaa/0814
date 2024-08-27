package com.mysite.noticeexam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;

	//readlist
	List<Notice> readlist() {
		return noticeRepository.findAll();
	}
	
	//readdetail
	Notice readdetail(Integer id) {
		Optional<Notice> ob = noticeRepository.findById(id);
		return ob.get();
	}
}
