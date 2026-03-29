// ═══ THEME MODAL — extracted component ═══
// Self-contained IIFE: injects its own CSS + HTML, wires up to window.SprintenTheme API
(function(){
'use strict';

// ── Helpers ──
function hexToRgba(hex, alpha) {
  const h = hex.replace('#','');
  const parts = h.length === 3
    ? [h[0]+h[0], h[1]+h[1], h[2]+h[2]]
    : [h.slice(0,2), h.slice(2,4), h.slice(4,6)];
  return 'rgba('+parseInt(parts[0],16)+','+parseInt(parts[1],16)+','+parseInt(parts[2],16)+','+alpha+')';
}

function rgbToHex(rgb) {
  if (rgb.startsWith('#')) return rgb;
  var m = rgb.match(/\d+/g);
  if (!m) return '#888888';
  return '#' + ((1<<24)+(+m[0]<<16)+(+m[1]<<8)+ +m[2]).toString(16).slice(1);
}

function cv(v) {
  return getComputedStyle(document.documentElement).getPropertyValue(v).trim();
}

// ── Accent color config ──
var ACCENTS = [
  { semantic:'--info',      accent:'--accent1', label:'Info',      darkDefault:'#5ca8e8', lightDefault:'#3b82d6' },
  { semantic:'--critical',  accent:'--accent2', label:'Critical',  darkDefault:'#ff8a8a', lightDefault:'#e05555' },
  { semantic:'--warning',   accent:'--accent3', label:'Warning',   darkDefault:'#f5a623', lightDefault:'#d48b0a' },
  { semantic:'--highlight', accent:'--accent4', label:'Highlight', darkDefault:'#b580f0', lightDefault:'#9455e0' },
  { semantic:'--success',   accent:'--accent5', label:'Success',   darkDefault:'#00C48C', lightDefault:'#00a676' }
];

// ── Font config ──
var BODY_FONTS = [
  { label:'Noto Sans',      value:"'Noto Sans', sans-serif",      google:'Noto+Sans:wght@300;400;500;600;700;800' },
  { label:'Inter',           value:"'Inter', sans-serif",           google:'Inter:wght@300;400;500;600;700;800' },
  { label:'System UI',       value:"system-ui, -apple-system, 'Segoe UI', Roboto, sans-serif", google:null },
  { label:'IBM Plex Sans',   value:"'IBM Plex Sans', sans-serif",  google:'IBM+Plex+Sans:wght@300;400;500;600;700' },
  { label:'Roboto',          value:"'Roboto', sans-serif",          google:'Roboto:wght@300;400;500;700' }
];

var MONO_FONTS = [
  { label:'Noto Sans Mono',  value:"'Noto Sans Mono', monospace",  google:'Noto+Sans+Mono:wght@400;500;600;700' },
  { label:'JetBrains Mono',  value:"'JetBrains Mono', monospace",  google:'JetBrains+Mono:wght@400;500;600;700' },
  { label:'Fira Code',       value:"'Fira Code', monospace",       google:'Fira+Code:wght@400;500;600;700' },
  { label:'IBM Plex Mono',   value:"'IBM Plex Mono', monospace",   google:'IBM+Plex+Mono:wght@400;500;600;700' },
  { label:'monospace',       value:'monospace',                     google:null }
];

var DEFAULT_RADIUS = 8;

// ── Inject CSS ──
var style = document.createElement('style');
style.id = 'tm-styles';
style.textContent = [
  // overlay
  '.tm-overlay{position:fixed;inset:0;z-index:10000;background:rgba(0,0,0,0.5);display:none;align-items:center;justify-content:center;opacity:0;transition:opacity .18s ease}',
  '.tm-overlay.tm-open{display:flex;opacity:1}',
  // panel
  '.tm-panel{background:var(--card);border:1px solid var(--border);border-radius:12px;width:460px;max-width:calc(100vw - 32px);max-height:calc(100vh - 48px);overflow-y:auto;padding:24px;box-shadow:0 20px 60px rgba(0,0,0,0.4);position:relative}',
  // header
  '.tm-header{display:flex;align-items:center;justify-content:space-between;margin-bottom:20px}',
  '.tm-title{font-size:16px;font-weight:700;color:var(--text);font-family:var(--font)}',
  '.tm-close{width:32px;height:32px;border:none;background:none;color:var(--text3);font-size:20px;cursor:pointer;display:flex;align-items:center;justify-content:center;border-radius:6px;transition:color .15s,background .15s}',
  '.tm-close:hover{color:var(--text);background:var(--surface)}',
  // sections
  '.tm-section{margin-bottom:20px}',
  '.tm-section-title{font-size:11px;font-weight:700;text-transform:uppercase;letter-spacing:0.8px;color:var(--text3);margin-bottom:10px;font-family:var(--font)}',
  // theme cards
  '.tm-theme-cards{display:grid;grid-template-columns:1fr 1fr;gap:10px}',
  '.tm-theme-card{border:2px solid var(--border);border-radius:var(--radius);padding:14px;cursor:pointer;transition:border-color .15s;display:flex;flex-direction:column;align-items:center;gap:8px}',
  '.tm-theme-card:hover{border-color:var(--border-hover)}',
  '.tm-theme-card.tm-active{border-color:var(--info)}',
  '.tm-theme-card-label{font-size:12px;font-weight:600;color:var(--text2);font-family:var(--font)}',
  // theme preview swatches
  '.tm-swatch-preview{width:100%;height:48px;border-radius:6px;display:flex;align-items:center;justify-content:center;gap:6px;font-size:11px;font-weight:600;letter-spacing:0.3px}',
  '.tm-swatch-dark{background:#111a27;color:#e8eef6;border:1px solid #2d3a4c}',
  '.tm-swatch-light{background:#f4f6f9;color:#1a2332;border:1px solid #d5dbe4}',
  '.tm-swatch-dot{width:8px;height:8px;border-radius:50%}',
  // accent colors
  '.tm-accents{display:flex;flex-wrap:wrap;gap:12px}',
  '.tm-accent-item{display:flex;flex-direction:column;align-items:center;gap:5px}',
  '.tm-accent-circle{width:36px;height:36px;border-radius:50%;border:2px solid var(--border);cursor:pointer;transition:border-color .15s,transform .1s;position:relative;overflow:hidden}',
  '.tm-accent-circle:hover{border-color:var(--border-hover);transform:scale(1.1)}',
  '.tm-accent-circle input{position:absolute;inset:-8px;width:52px;height:52px;opacity:0;cursor:pointer}',
  '.tm-accent-label{font-size:10px;font-weight:600;color:var(--text3);font-family:var(--font)}',
  // typography
  '.tm-font-row{display:flex;gap:10px;margin-bottom:10px}',
  '.tm-font-group{flex:1;display:flex;flex-direction:column;gap:4px}',
  '.tm-font-group-label{font-size:10px;font-weight:600;color:var(--text3);font-family:var(--font)}',
  '.tm-select{width:100%;padding:8px 10px;border:1px solid var(--border);border-radius:var(--radius);background:var(--surface);color:var(--text);font-family:var(--font);font-size:12px;font-weight:500;cursor:pointer;outline:none;transition:border-color .15s;appearance:none;-webkit-appearance:none;background-image:url("data:image/svg+xml,%3Csvg xmlns=\'http://www.w3.org/2000/svg\' width=\'10\' height=\'6\'%3E%3Cpath d=\'M0 0l5 6 5-6z\' fill=\'%236b7f99\'/%3E%3C/svg%3E");background-repeat:no-repeat;background-position:right 10px center}',
  '.tm-select:hover{border-color:var(--border-hover)}',
  '.tm-select:focus{border-color:var(--info)}',
  // radius
  '.tm-radius-row{display:flex;align-items:center;gap:14px}',
  '.tm-radius-slider{flex:1;-webkit-appearance:none;appearance:none;height:6px;border-radius:3px;background:var(--surface);outline:none;border:1px solid var(--border)}',
  '.tm-radius-slider::-webkit-slider-thumb{-webkit-appearance:none;width:18px;height:18px;border-radius:50%;background:var(--info);cursor:pointer;border:2px solid var(--card);box-shadow:0 1px 4px rgba(0,0,0,0.3)}',
  '.tm-radius-slider::-moz-range-thumb{width:18px;height:18px;border-radius:50%;background:var(--info);cursor:pointer;border:2px solid var(--card);box-shadow:0 1px 4px rgba(0,0,0,0.3)}',
  '.tm-radius-val{font-family:var(--mono);font-size:13px;font-weight:700;color:var(--text);min-width:36px;text-align:right}',
  // footer
  '.tm-footer{padding-top:16px;border-top:1px solid var(--border);display:flex;justify-content:flex-end}',
  '.tm-reset-btn{padding:8px 16px;border:1px solid var(--border);border-radius:var(--radius);background:var(--surface);color:var(--text2);font-family:var(--font);font-size:11px;font-weight:600;cursor:pointer;transition:all .15s}',
  '.tm-reset-btn:hover{color:var(--text);border-color:var(--border-hover)}',
  // scrollbar inside panel
  '.tm-panel::-webkit-scrollbar{width:6px}',
  '.tm-panel::-webkit-scrollbar-thumb{background:var(--border);border-radius:3px}',
  // responsive
  '@media(max-width:600px){.tm-font-row{flex-direction:column}.tm-accents{justify-content:center}}'
].join('\n');
document.head.appendChild(style);

// ── Inject HTML ──
function buildAccentHTML() {
  return ACCENTS.map(function(a, i) {
    return '<div class="tm-accent-item">' +
      '<div class="tm-accent-circle" data-index="'+i+'" style="background:var('+a.semantic+')">' +
        '<input type="color" tabindex="-1">' +
      '</div>' +
      '<span class="tm-accent-label">'+a.label+'</span>' +
    '</div>';
  }).join('');
}

function buildSelectOptions(fonts) {
  return fonts.map(function(f) {
    return '<option value="'+f.value+'">'+f.label+'</option>';
  }).join('');
}

var overlay = document.createElement('div');
overlay.className = 'tm-overlay';
overlay.id = 'themeModal';
overlay.innerHTML =
  '<div class="tm-panel">' +
    '<div class="tm-header">' +
      '<span class="tm-title">Customize Theme</span>' +
      '<button class="tm-close" title="Close">&times;</button>' +
    '</div>' +
    // Base theme
    '<div class="tm-section">' +
      '<div class="tm-section-title">Base Theme</div>' +
      '<div class="tm-theme-cards">' +
        '<div class="tm-theme-card" data-theme="dark">' +
          '<div class="tm-swatch-preview tm-swatch-dark">' +
            '<span class="tm-swatch-dot" style="background:#5ca8e8"></span>' +
            '<span class="tm-swatch-dot" style="background:#00C48C"></span>' +
            '<span class="tm-swatch-dot" style="background:#b580f0"></span>' +
            'Dark' +
          '</div>' +
          '<span class="tm-theme-card-label">Dark Mode</span>' +
        '</div>' +
        '<div class="tm-theme-card" data-theme="light">' +
          '<div class="tm-swatch-preview tm-swatch-light">' +
            '<span class="tm-swatch-dot" style="background:#3b82d6"></span>' +
            '<span class="tm-swatch-dot" style="background:#00a676"></span>' +
            '<span class="tm-swatch-dot" style="background:#9455e0"></span>' +
            'Light' +
          '</div>' +
          '<span class="tm-theme-card-label">Light Mode</span>' +
        '</div>' +
      '</div>' +
    '</div>' +
    // Accent colors
    '<div class="tm-section">' +
      '<div class="tm-section-title">Accent Colors</div>' +
      '<div class="tm-accents">' + buildAccentHTML() + '</div>' +
    '</div>' +
    // Typography
    '<div class="tm-section">' +
      '<div class="tm-section-title">Typography</div>' +
      '<div class="tm-font-row">' +
        '<div class="tm-font-group">' +
          '<span class="tm-font-group-label">Body Font</span>' +
          '<select class="tm-select" id="tmBodyFont">' + buildSelectOptions(BODY_FONTS) + '</select>' +
        '</div>' +
        '<div class="tm-font-group">' +
          '<span class="tm-font-group-label">Mono Font</span>' +
          '<select class="tm-select" id="tmMonoFont">' + buildSelectOptions(MONO_FONTS) + '</select>' +
        '</div>' +
      '</div>' +
    '</div>' +
    // Border Radius
    '<div class="tm-section">' +
      '<div class="tm-section-title">Border Radius</div>' +
      '<div class="tm-radius-row">' +
        '<input type="range" class="tm-radius-slider" id="tmRadius" min="0" max="16" step="1" value="'+DEFAULT_RADIUS+'">' +
        '<span class="tm-radius-val" id="tmRadiusVal">'+DEFAULT_RADIUS+'px</span>' +
      '</div>' +
    '</div>' +
    // Footer
    '<div class="tm-footer">' +
      '<button class="tm-reset-btn">Reset to Defaults</button>' +
    '</div>' +
  '</div>';
document.body.appendChild(overlay);

// ── DOM refs ──
var panel       = overlay.querySelector('.tm-panel');
var closeBtn    = overlay.querySelector('.tm-close');
var themeCards  = overlay.querySelectorAll('.tm-theme-card');
var accentEls   = overlay.querySelectorAll('.tm-accent-circle');
var bodyFontSel = document.getElementById('tmBodyFont');
var monoFontSel = document.getElementById('tmMonoFont');
var radiusSlider= document.getElementById('tmRadius');
var radiusVal   = document.getElementById('tmRadiusVal');
var resetBtn    = overlay.querySelector('.tm-reset-btn');
var toggleBtn   = document.getElementById('themeToggle');
var toggleIcon  = toggleBtn.querySelector('.toggle-icon');
var toggleLabel = toggleBtn.querySelector('.toggle-label');

// ── Google Fonts loader ──
var loadedFonts = {};
function loadGoogleFont(googleStr) {
  if (!googleStr || loadedFonts[googleStr]) return;
  loadedFonts[googleStr] = true;
  var link = document.createElement('link');
  link.rel = 'stylesheet';
  link.href = 'https://fonts.googleapis.com/css2?family=' + googleStr + '&display=swap';
  link.dataset.tmFont = '1';
  document.head.appendChild(link);
}
// Pre-mark the default fonts as loaded
loadedFonts[BODY_FONTS[0].google] = true;
loadedFonts[MONO_FONTS[0].google] = true;

// ── Open / Close ──
function openModal() {
  syncUI();
  overlay.classList.add('tm-open');
}
function closeModal() {
  overlay.classList.remove('tm-open');
}

toggleBtn.addEventListener('click', function(e) {
  e.preventDefault();
  openModal();
});
closeBtn.addEventListener('click', closeModal);
overlay.addEventListener('click', function(e) {
  if (e.target === overlay) closeModal();
});
document.addEventListener('keydown', function(e) {
  if (e.key === 'Escape' && overlay.classList.contains('tm-open')) closeModal();
});

// ── Update sidebar toggle button icon ──
function updateToggleBtn() {
  var theme = window.SprintenTheme.getTheme();
  if (theme === 'light') {
    toggleIcon.textContent = '☀️';
    toggleLabel.textContent = 'Light';
  } else {
    toggleIcon.textContent = '🌙';
    toggleLabel.textContent = 'Dark';
  }
}

// ── Base theme selection ──
themeCards.forEach(function(card) {
  card.addEventListener('click', function() {
    var theme = card.dataset.theme;
    window.SprintenTheme.applyTheme(theme);
    // Re-apply saved accents after theme switch
    restoreAccents();
    updateToggleBtn();
    syncThemeCards();
  });
});

function syncThemeCards() {
  var current = window.SprintenTheme.getTheme();
  themeCards.forEach(function(c) {
    c.classList.toggle('tm-active', c.dataset.theme === current);
  });
}

// ── Accent colors ──
function setAccentColor(index, hex) {
  var a = ACCENTS[index];
  var isLight = window.SprintenTheme.getTheme() === 'light';
  var dimAlpha = isLight ? 0.08 : 0.1;
  var borderAlpha = isLight ? 0.2 : 0.25;
  var root = document.documentElement.style;

  root.setProperty(a.semantic, hex);
  root.setProperty(a.accent + '-dim', hexToRgba(hex, dimAlpha));
  root.setProperty(a.accent + '-border', hexToRgba(hex, borderAlpha));
}

accentEls.forEach(function(el) {
  var input = el.querySelector('input');
  el.addEventListener('click', function(e) {
    if (e.target !== input) input.click();
  });
  input.addEventListener('input', function() {
    var idx = parseInt(el.dataset.index);
    var hex = input.value;
    el.style.background = hex;
    setAccentColor(idx, hex);
    saveAccents();
    window.SprintenTheme.rerender();
  });
});

function saveAccents() {
  var data = {};
  accentEls.forEach(function(el) {
    var idx = parseInt(el.dataset.index);
    var input = el.querySelector('input');
    data[ACCENTS[idx].semantic] = input.value;
  });
  localStorage.setItem('sprinten-accents', JSON.stringify(data));
}

function restoreAccents() {
  var raw = localStorage.getItem('sprinten-accents');
  if (!raw) return;
  try {
    var data = JSON.parse(raw);
    ACCENTS.forEach(function(a, i) {
      if (data[a.semantic]) {
        setAccentColor(i, data[a.semantic]);
      }
    });
  } catch(e) {}
}

function syncAccentUI() {
  ACCENTS.forEach(function(a, i) {
    var el = accentEls[i];
    var input = el.querySelector('input');
    var current = rgbToHex(cv(a.semantic));
    el.style.background = current;
    input.value = current;
  });
}

// ── Typography ──
bodyFontSel.addEventListener('change', function() {
  var chosen = BODY_FONTS.find(function(f) { return f.value === bodyFontSel.value; });
  if (chosen && chosen.google) loadGoogleFont(chosen.google);
  document.documentElement.style.setProperty('--font', bodyFontSel.value);
  saveTypography();
  window.SprintenTheme.rerender();
});

monoFontSel.addEventListener('change', function() {
  var chosen = MONO_FONTS.find(function(f) { return f.value === monoFontSel.value; });
  if (chosen && chosen.google) loadGoogleFont(chosen.google);
  document.documentElement.style.setProperty('--mono', monoFontSel.value);
  saveTypography();
  window.SprintenTheme.rerender();
});

function saveTypography() {
  localStorage.setItem('sprinten-typography', JSON.stringify({
    font: bodyFontSel.value,
    mono: monoFontSel.value
  }));
}

function restoreTypography() {
  var raw = localStorage.getItem('sprinten-typography');
  if (!raw) return;
  try {
    var data = JSON.parse(raw);
    if (data.font) {
      var bf = BODY_FONTS.find(function(f) { return f.value === data.font; });
      if (bf) {
        if (bf.google) loadGoogleFont(bf.google);
        bodyFontSel.value = bf.value;
        document.documentElement.style.setProperty('--font', bf.value);
      }
    }
    if (data.mono) {
      var mf = MONO_FONTS.find(function(f) { return f.value === data.mono; });
      if (mf) {
        if (mf.google) loadGoogleFont(mf.google);
        monoFontSel.value = mf.value;
        document.documentElement.style.setProperty('--mono', mf.value);
      }
    }
  } catch(e) {}
}

// ── Border Radius ──
radiusSlider.addEventListener('input', function() {
  var v = radiusSlider.value;
  radiusVal.textContent = v + 'px';
  document.documentElement.style.setProperty('--radius', v + 'px');
  localStorage.setItem('sprinten-radius', v);
});

function restoreRadius() {
  var saved = localStorage.getItem('sprinten-radius');
  if (saved !== null) {
    radiusSlider.value = saved;
    radiusVal.textContent = saved + 'px';
    document.documentElement.style.setProperty('--radius', saved + 'px');
  }
}

// ── Reset ──
resetBtn.addEventListener('click', function() {
  // Clear inline overrides
  var root = document.documentElement.style;
  ACCENTS.forEach(function(a) {
    root.removeProperty(a.semantic);
    root.removeProperty(a.accent + '-dim');
    root.removeProperty(a.accent + '-border');
  });
  root.removeProperty('--font');
  root.removeProperty('--mono');
  root.removeProperty('--radius');

  // Clear localStorage
  localStorage.removeItem('sprinten-accents');
  localStorage.removeItem('sprinten-typography');
  localStorage.removeItem('sprinten-radius');

  // Remove dynamically loaded font links
  document.querySelectorAll('link[data-tm-font]').forEach(function(l) { l.remove(); });
  loadedFonts = {};
  loadedFonts[BODY_FONTS[0].google] = true;
  loadedFonts[MONO_FONTS[0].google] = true;

  // Reset UI controls
  bodyFontSel.value = BODY_FONTS[0].value;
  monoFontSel.value = MONO_FONTS[0].value;
  radiusSlider.value = DEFAULT_RADIUS;
  radiusVal.textContent = DEFAULT_RADIUS + 'px';

  // Re-apply current base theme
  window.SprintenTheme.applyTheme(window.SprintenTheme.getTheme());
  syncUI();
});

// ── Sync all UI state ──
function syncUI() {
  syncThemeCards();
  syncAccentUI();
  updateToggleBtn();
  // Sync font selects
  var currentFont = cv('--font');
  var currentMono = cv('--mono');
  BODY_FONTS.forEach(function(f) { if (currentFont.indexOf(f.label) !== -1) bodyFontSel.value = f.value; });
  MONO_FONTS.forEach(function(f) { if (currentMono.indexOf(f.label) !== -1) monoFontSel.value = f.value; });
  // Sync radius
  var currentRadius = parseInt(cv('--radius')) || DEFAULT_RADIUS;
  radiusSlider.value = currentRadius;
  radiusVal.textContent = currentRadius + 'px';
}

// ── Init: restore saved customizations ──
restoreAccents();
restoreTypography();
restoreRadius();
updateToggleBtn();

})();
