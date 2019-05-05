package tc.pbkk.servistukangantar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.pbkk.servistukangantar.dao.DeliveryRepository;
import tc.pbkk.servistukangantar.model.Delivery;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Override
	public List<Delivery> getAllDelivery() {
		List<Delivery> deliveries = (List<Delivery>) deliveryRepository.findAll();
		return deliveries;
	}

	@Override
	public void addDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
		
	}

	@Override
	public Delivery getDelivery(Integer deliveryId) {
		
		return deliveryRepository.findById(deliveryId).get();
	}

	@Override
	public void updateDelivery(Integer deliveryId, Boolean isArrived, Date sentAt, Date arrivedAt) {
		Delivery delivery = getDelivery(deliveryId);
		
		if(delivery == null) {
			throw new RuntimeException(" Not Available");
		}
		delivery.setIsArrived(isArrived);
		delivery.setSentAt(sentAt);
		delivery.setArrivedAt(arrivedAt);
	}

	@Override
	public void deleteDelivery(Integer deliveryId) {
		deliveryRepository.deleteById(deliveryId);
	}
	

}