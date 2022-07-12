import notificationIcon from '../../assets/img/notification-icon.svg';
import './styles.css';

export function NotificationButton() {
  return (
    <div className="dsmeta-red-btn">
      <img src={notificationIcon} alt="Notificar" />
    </div>
  );
}