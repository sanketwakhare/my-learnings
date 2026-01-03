import styles from "./HolyGrail.module.css";

export default function HolyGrail() {
  return (
    <div className={styles.holyGrailContainer}>
      <header>Header</header>
      <div className={styles.columns}>
        <nav>Navigation</nav>
        <main>Main</main>
        <aside>Sidebar</aside>
      </div>
      <footer>Footer</footer>
    </div>
  );
}
