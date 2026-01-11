import { useEffect, useState } from "react";
import "./DigitalClock.css";

// segment mapping for 7-segment display
// Each array represents the state of the 7 segments for digits 0-9
// The order of segments is: [a, b, c, d, e, f, g]
// 1 means the segment is on, 0 means it's off
//     a - top
//    ----
// f |    | b
//    ----  g - middle
// e |    | c
//    ----
//     d - bottom
const segmentMapping: { [key: number]: number[] } = {
  0: [1, 1, 1, 1, 1, 1, 0],
  1: [0, 1, 1, 0, 0, 0, 0],
  2: [1, 1, 0, 1, 1, 0, 1],
  3: [1, 1, 1, 1, 0, 0, 1],
  4: [0, 1, 1, 0, 0, 1, 1],
  5: [1, 0, 1, 1, 0, 1, 1],
  6: [1, 0, 1, 1, 1, 1, 1],
  7: [1, 1, 1, 0, 0, 0, 0],
  8: [1, 1, 1, 1, 1, 1, 1],
  9: [1, 1, 1, 1, 0, 1, 1],
};

// Seven segment digit display
const SevenSegmentDisplay = ({ digit }: { digit: number }) => {
  const segments = segmentMapping[digit];
  const [a, b, c, d, e, f, g] = segments;

  return (
    <div className="seven-segment-display">
      <div className={`segment seg-a ${a ? "on" : "off"}`}></div>
      <div className={`segment seg-b ${b ? "on" : "off"}`}></div>
      <div className={`segment seg-c ${c ? "on" : "off"}`}></div>
      <div className={`segment seg-d ${d ? "on" : "off"}`}></div>
      <div className={`segment seg-e ${e ? "on" : "off"}`}></div>
      <div className={`segment seg-f ${f ? "on" : "off"}`}></div>
      <div className={`segment seg-g ${g ? "on" : "off"}`}></div>
    </div>
  );
};

// Colon component
const Colon = () => {
  return (
    <div className="colon">
      <div className="dot"></div>
      <div className="dot"></div>
    </div>
  );
};

export default function DigitalClock() {
  const [time, setTime] = useState<Date>(new Date());

  useEffect(() => {
    const timerId = setInterval(() => {
      setTime(new Date());
    }, 1000);

    return () => clearInterval(timerId);
  }, []);

  const hours = time.getHours();
  const minutes = time.getMinutes();
  const seconds = time.getSeconds();

  return (
    <div className="clock-container">
      <div className="digital-clock">
        <div className="digit-group">
          <SevenSegmentDisplay digit={Math.floor(hours / 10)} />
          <SevenSegmentDisplay digit={hours % 10} />
        </div>
        <Colon />
        <div className="digit-group">
          <SevenSegmentDisplay digit={Math.floor(minutes / 10)} />
          <SevenSegmentDisplay digit={minutes % 10} />
        </div>
        <Colon />
        <div className="digit-group">
          <SevenSegmentDisplay digit={Math.floor(seconds / 10)} />
          <SevenSegmentDisplay digit={seconds % 10} />
        </div>
      </div>
    </div>
  );
}
