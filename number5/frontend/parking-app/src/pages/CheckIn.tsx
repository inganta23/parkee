import { useState, useRef } from "react";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { checkIn } from "@/api";
import { convertToIndonesianTime } from "@/lib/utils";
import { useReactToPrint } from "react-to-print";
import { toast } from "sonner";

interface Ticket {
  plateNumber: string;
  checkInTime?: string;
  checkOutTime?: string;
  totalPrice?: number;
}

const CheckIn: React.FC = () => {
  const [plateNumber, setPlateNumber] = useState<string>("");
  const [ticket, setTicket] = useState<Ticket | null>(null);
  const [error, setError] = useState<string>("");
  const contentRef = useRef<HTMLDivElement>(null);
  const reactToPrintFn = useReactToPrint({ contentRef });

  const handleCheckIn = async () => {
    setError("");
    setTicket(null);
    try {
      const data: Ticket = await checkIn(plateNumber);
      setTicket(data);
      toast.success("Check-in successful!");
    } catch (err: any) {
      setError(err?.error || "Check-in failed.");
      toast.error(err?.error || "Check-in failed.");
    }
  };

  return (
    <div className="max-w-lg mx-auto mt-10 p-4">
      <h1 className="text-2xl font-bold mb-4">Check-In</h1>
      <div className="flex gap-2">
        <Input
          type="text"
          placeholder="Enter Plate Number"
          value={plateNumber}
          onChange={(e) => setPlateNumber(e.target.value)}
        />
        <Button onClick={handleCheckIn} className="cursor-pointer">
          Check-In
        </Button>
      </div>
      {error && <p className="text-red-500 mt-2">{error}</p>}

      {ticket && (
        <div ref={contentRef}>
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
            </CardContent>
          </Card>
        </div>
      )}
      {ticket && (
        <Button
          className="mt-2 cursor-pointer"
          onClick={() => reactToPrintFn()}
        >
          Print Ticket
        </Button>
      )}
    </div>
  );
};

export default CheckIn;
