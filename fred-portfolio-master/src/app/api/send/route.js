import { NextResponse } from "next/server";
import { Resend } from "resend";

const apiKey = "re_SyXzdhcd_K8Fr3asm7jKRGXW3Ffqjfs69git";
const resend = new Resend(apiKey);

const fromEmail = "fredericksamangazw@gmail.com";

export async function POST(req, res) {
  const { email, subject, message } = await req.json();
  console.log(email, subject, message);
  try {
    const data = await resend.emails.send({
      from: fromEmail,
      to: ["fredericksamangazw@gmail.com", email],
      subject: subject,
      react: (
        <>
          <h1>{subject}</h1>
          <p>Thank you for contacting us!</p>
          <p>New message submitted:</p>
          <p>{message}</p>
        </>
      ),
    });
    return NextResponse.json(data);
  } catch (error) {
    return NextResponse.json({ error });
  }
}
