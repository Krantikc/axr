package com.axr.dao;

import java.util.List;

import com.axr.model.Slide;

public interface SlideDAO {

	public boolean findSlideById(int slideId);
	public List<Slide> getSlides();
	public int createSlide(Slide slide);
	public boolean updateSlide(Slide slide);
	public boolean deleteSlideById(int slideId);

}
