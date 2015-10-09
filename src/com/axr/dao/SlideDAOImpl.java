package com.axr.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.axr.model.Caption;
import com.axr.model.ProductGraphicsColor;
import com.axr.model.Slide;
import com.axr.util.HibernateUtil;

public class SlideDAOImpl implements SlideDAO {
	SessionFactory sessionFactory = HibernateUtil.sessionFactory;
	
	@Override
	public boolean findSlideById(int slideId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Slide slide = (Slide) session.createCriteria(Slide.class).add(Restrictions.eq("slideId", slideId)).uniqueResult();
		if(slide != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Slide> getSlides() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Slide> slidesList = session.createCriteria(Slide.class).list();
		return slidesList;
	}

	@Override
	public int createSlide(Slide slide) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int slideId = (Integer) session.save(slide);
		//session.save(slide.getCaptions());
		List<Caption> captions = slide.getCaptions();
		for (Caption caption : captions) {
			session.save(caption);
		}
		session.getTransaction().commit();
		session.close();
		return slideId;
	}

	@Override
	public boolean updateSlide(Slide slide) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSlideById(int slideId) {
		boolean isSlideAvailable = new SlideDAOImpl().findSlideById(slideId);
		if(isSlideAvailable) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			Slide slide = (Slide) session.load(Slide.class, slideId);
			session.delete(slide);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		Slide slide = new Slide( "slide 1", "caption1.jpg", "net");
		List<Caption> captions = new ArrayList<>();
		
		Caption caption1 = new Caption();
		caption1.setImage("sdf");
		caption1.setPosition("top");
		caption1.setSlide(slide);
		

		captions.add(caption1);
		
		caption1 = new Caption();
		caption1.setImage("sdf3");
		caption1.setPosition("lfjjrtt");
		caption1.setSlide(slide);
		
		captions.add(caption1);
		
		slide.setCaptions(captions);

		new SlideDAOImpl().createSlide(slide);
		
		new SlideDAOImpl().deleteSlideById(7);
		
		List<Slide> slidesList = new SlideDAOImpl().getSlides();
		
		for (Slide slide2 : slidesList) {
			System.out.println(slide2.getImage());
			List<Caption> capts = slide2.getCaptions();
			for (Caption caption : capts) {
				System.out.println(caption.getImage());
			}
		}
	}

}
