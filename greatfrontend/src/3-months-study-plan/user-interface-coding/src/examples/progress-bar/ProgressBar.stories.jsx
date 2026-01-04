import ProgressBar from "./ProgressBar";

export default function ProgressBarStories() {
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        rowGap: "16px",
      }}
    >
      <ProgressBar value={50} />
      <ProgressBar value={20} />
      <ProgressBar value={30} height={20} />
      <ProgressBar value={100} height={20} />
    </div>
  );
}
