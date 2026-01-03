import submitForm from "./submitForm";

export default function ContactForm() {
  return (
    <form
      // Ignore the onSubmit prop, it's used by GFE to
      // intercept the form submit event to check your solution.
      onSubmit={submitForm}
      action={"https://questions.greatfrontend.com/api/questions/contact-form"}
      method="post"
    >
      <div style={{ display: "flex", gap: "8px", flexDirection: "column" }}>
        <div>
          <label labelFor="name">Name</label>
          <input type="text" name="name" />
        </div>
        <div>
          <label labelFor="name">Email</label>
          <input type="text" name="email" />
        </div>
        <div>
          <label labelFor="message">Message</label>
          <textarea
            name="message"
            rows="3"
            cols="50"
            style={{ display: "block", marginBottom: "8px" }}
          />
        </div>
      </div>
      <input type="submit" />
    </form>
  );
}
