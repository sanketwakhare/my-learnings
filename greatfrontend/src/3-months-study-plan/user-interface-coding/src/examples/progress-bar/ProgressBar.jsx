import "./ProgressBar.css";

export default function ProgressBar({
  value = 0,
  showLabel = true,
  height = 40,
  backgroundColor = "#e0e0e0",
  progressColor = "#0d6efd",
}) {
  // Clamp value between 0 and 100
  const progress = Math.min(Math.max(value, 0), 100);

  return (
    <div
      className="progress-bar-container"
      style={{
        height: `${height}px`,
        backgroundColor: backgroundColor,
        borderRadius: `${height / 2}px`,
      }}
      role="progressbar"
      aria-valuenow={progress}
      aria-valuemin="0"
      aria-valuemax="100"
    >
      <div
        className="progress-bar-fill"
        style={{
          width: `${progress}%`,
          backgroundColor: progressColor,
          borderRadius: `${height / 2}px`,
        }}
      >
        {showLabel && progress > 0 && (
          <span
            className="progress-bar-label"
            style={{ fontSize: `${height * 0.7}px` }}
          >
            {progress}%
          </span>
        )}
      </div>
    </div>
  );
}
