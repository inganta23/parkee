import axios from "axios";

const API_URL = "http://localhost:8080/api";

interface Ticket {
  plateNumber: string;
  checkInTime?: string;
  checkOutTime?: string;
  totalPrice?: number;
}

interface APIError {
  message: string;
}

export const checkIn = async (plateNumber: string): Promise<Ticket> => {
  try {
    const response = await axios.post<Ticket>(`${API_URL}/check-in`, {
      plateNumber,
    });
    return response.data;
  } catch (error: any) {
    throw (error.response?.data as APIError) || { message: "Check-in failed." };
  }
};

export const getTicket = async (plateNumber: string): Promise<Ticket> => {
  try {
    const response = await axios.get(`${API_URL}/ticket/${plateNumber}`);
    return response.data;
  } catch (error: any) {
    throw (
      (error.response?.data as APIError) || { message: "Ticket not found." }
    );
  }
};

export const checkOut = async (plateNumber: string): Promise<Ticket> => {
  try {
    const response = await axios.post<Ticket>(`${API_URL}/check-out`, {
      plateNumber,
    });
    return response.data;
  } catch (error: any) {
    throw (
      (error.response?.data as APIError) || { message: "Check-out failed." }
    );
  }
};
