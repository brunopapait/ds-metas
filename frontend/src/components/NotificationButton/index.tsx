import axios from "axios";
import notificationIcon from "../../assets/img/notification-icon.svg";
import { BASE_URL } from "../../utils/request";
import "./styles.css";

type Props = {
  saleId: number;
};

export function NotificationButton({ saleId }: Props) {

  function handleClick(saleId: number) {
    axios.get(`${BASE_URL}/sales/${saleId}/notification`);
  }

  return (
    <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
      <img src={notificationIcon} alt="Notificar" />
    </div>
  );
}
