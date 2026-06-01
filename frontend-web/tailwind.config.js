/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        base: 'var(--color-bg-base)',
        surface: 'var(--color-surface)',
        surfaceDark: 'var(--color-surface-dark)',
        border: 'var(--color-border)',
        primary: {
          DEFAULT: 'var(--color-primary)',
          hover: 'var(--color-primary-hover)'
        },
        textMain: 'var(--color-text-main)',
        textMuted: 'var(--color-text-muted)'
      }
    },
  },
  plugins: [],
}
