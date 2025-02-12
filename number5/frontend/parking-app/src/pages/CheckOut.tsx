import { useState } from "react";
import { getTicket, checkOut } from "../api";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { convertToIndonesianTime } from "@/lib/utils";
import { toast } from "sonner";

interface Ticket {
  plateNumber: string;
  checkInTime?: string;
  checkOutTime?: string;
  totalPrice?: number;
}

const CheckOut: React.FC = () => {
  const [plateNumber, setPlateNumber] = useState<string>("");
  const [ticket, setTicket] = useState<Ticket | null>(null);
  const [error, setError] = useState<string>("");

  const handleRetrieve = async () => {
    setError("");
    setTicket(null);
    try {
      const data: Ticket = await getTicket(plateNumber);
      setTicket(data);
    } catch (err: any) {
      setError(err?.error || "Ticket not found.");
    }
  };

  const handleCheckOut = async () => {
    setError("");
    try {
      await checkOut(plateNumber);
      setTicket((prevTicket) =>
        prevTicket
          ? { ...prevTicket, checkOutTime: new Date().toISOString() }
          : null
      );
      toast.success("Check-out successful!");
    } catch (err: any) {
      setError(err?.error || "Check-out failed.");
      toast.error(err?.error || "Check-out failed.");
    }
  };

  return (
    <div className="max-w-lg mx-auto mt-10 p-4">
      <h1 className="text-2xl font-bold mb-4">Check-Out</h1>
      <div className="flex gap-2">
        <Input
          type="text"
          placeholder="Enter Plate Number"
          value={plateNumber}
          onChange={(e) => setPlateNumber(e.target.value)}
        />
        <Button className="cursor-pointer" onClick={handleRetrieve}>
          Retrieve Ticket
        </Button>
      </div>
      {error && <p className="text-red-500 mt-2">{error}</p>}

      {ticket && (
        <Card className="mt-4">
          <CardHeader>
            <CardTitle>Parking Ticket</CardTitle>
          </CardHeader>
          <CardContent>
            <p>Plate Number: {ticket.plateNumber}</p>
            <p>
              Check-In Time:{" "}
              {ticket.checkInTime
                ? convertToIndonesianTime(ticket.checkInTime)
                : ""}
            </p>
            <p>
              Check-Out Time:{" "}
              {ticket.checkOutTime
                ? convertToIndonesianTime(ticket.checkOutTime)
                : "Not checked out"}
            </p>
            <p>
              Total Price:{" "}
              {ticket.totalPrice ? `Rp${ticket.totalPrice}` : "Calculating..."}
            </p>
            {!ticket.checkOutTime && (
              <Button className="mt-2 cursor-pointer" onClick={handleCheckOut}>
                Finish Transaction
              </Button>
            )}
          </CardContent>
        </Card>
      )}
    </div>
  );
};

export default CheckOut;
