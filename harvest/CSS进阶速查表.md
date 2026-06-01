# CSS 进阶速查表（Transition / Transform / Animation）

---

## 一、Transition（过渡）

**作用**：让 CSS 属性值变化时变平滑，而不是瞬间跳变。必须通过状态变化触发（hover、focus、点击添加 class 等）。

### 1.1 完整写法

```css
/* 简写（最常用，4 个值按顺序写） */
transition: 属性名 时长 速度曲线 延迟时间;

/* 分别写（需要单独控制时用） */
transition-property: background, transform;  /* 对哪些属性生效 */
transition-duration: 0.3s;                   /* 变化持续多久 */
transition-timing-function: ease;            /* 变化速度怎么变 */
transition-delay: 0s;                        /* 等多久才开始变 */
```

### 1.2 常用实例（直接复制用）

```css
/* === 按钮 hover：背景色 0.3s 平滑变 + 轻微放大 === */
.btn {
  background: #4A90D9;
  transition: background 0.3s, transform 0.2s;
}
.btn:hover {
  background: #e74c3c;        /* 背景从蓝变红，0.3s 平滑过渡 */
  transform: scale(1.05);     /* 放大到 105%，0.2s 平滑过渡 */
}

/* === 卡片 hover：上浮 + 阴影加深 === */
.card {
  transition: transform 0.35s, box-shadow 0.35s;
}
.card:hover {
  transform: translateY(-10px);                      /* 上浮 10px */
  box-shadow: 0 10px 30px rgba(0,0,0,0.2);           /* 阴影变大 */
}

/* === 所有属性统一过渡（简单但性能差一点） === */
transition: all 0.3s ease;
/* all = 所有可过渡的属性（颜色、尺寸、位置等）都用同一套时长和曲线 */
```

### 1.3 timing-function（速度曲线）详解

```css
/* 小球从左边移到右边，时长 2s，对比不同曲线 */

transition: left 2s ease;
/* 效果：起跑慢 → 中途快 → 停之前慢（最自然，默认值） */

transition: left 2s linear;
/* 效果：从头到尾匀速，机械感重 */

transition: left 2s ease-in;
/* 效果：起跑慢 → 越来越快（适合元素离开屏幕） */

transition: left 2s ease-out;
/* 效果：起跑快 → 越来越慢（适合元素进入屏幕） */

transition: left 2s ease-in-out;
/* 效果：慢→快→慢，起跑和到站都缓（比 ease 更对称） */
```

| 值 | 感觉 | 适合场景 |
|----|------|---------|
| `ease` | 慢→快→慢 | 默认，大多数情况用这个 |
| `linear` | 全程匀速 | 旋转加载、滚动字幕 |
| `ease-in` | 慢→快 | 元素飞出屏幕 |
| `ease-out` | 快→慢 | 元素滑入屏幕 |
| `ease-in-out` | 慢→快→慢 | 需要明显缓入缓出的时候 |

### 1.4 逐属性过渡（不同属性不同时长）

```css
/* 背景 0.3s 变，transform 0.2s 变，各走各的 */
transition: background 0.3s ease, transform 0.2s ease;

/* 再加 box-shadow，0.4s 变 */
transition: background 0.3s, transform 0.2s, box-shadow 0.4s;
```

### 1.5 加延迟

```css
transition: opacity 0.5s ease 0.2s;
/*                                ↑ 等 0.2s 后才开始过渡 */
/* 效果：hover 后先停顿 0.2 秒，再花 0.5 秒慢慢变透明 */
```

### 1.6 输入框 focus 过渡（完整示例）

```css
.input {
  width: 200px;
  border: 2px solid #ddd;
  transition: border-color 0.3s, box-shadow 0.3s, width 0.3s;
}
.input:focus {
  width: 300px;                    /* 变宽 */
  border-color: #4A90D9;           /* 边框变蓝 */
  box-shadow: 0 0 8px rgba(74,144,217,0.3);  /* 发光 */
  outline: none;                   /* 去掉默认轮廓 */
}
```

---

## 二、Transform（变换）

**作用**：改变元素的位置、角度、大小、形状。**不脱离文档流**（原来占的坑还在）。常配合 transition 做动效。

### 2.1 translate（平移）——移动位置

```css
/* X 轴平移（水平方向） */
transform: translateX(50px);
/* 效果：元素向右移动 50px（正=右，负=左） */
/* 原来占的位置保留，后面的元素不会顶上来 */

transform: translateX(-30px);
/* 效果：元素向左移动 30px */

/* Y 轴平移（垂直方向） */
transform: translateY(-20px);
/* 效果：元素向上移动 20px（负=上，正=下） */

transform: translateY(40px);
/* 效果：元素向下移动 40px */

/* 同时 X + Y */
transform: translate(30px, -20px);
/* 效果：右移 30px 且上移 20px */

transform: translate(-50%, -50%);
/* 效果：左移自身一半 + 上移自身一半 → 用于居中 */
```

### 2.2 rotate（旋转）——转动角度

```css
transform: rotate(45deg);
/* 效果：顺时针旋转 45° */

transform: rotate(-30deg);
/* 效果：逆时针旋转 30° */

transform: rotate(360deg);
/* 效果：顺时针转一整圈（配合 transition 就是旋转动画） */

transform: rotate(15deg);
/* 效果：轻微倾斜，做 hover 效果常用 */
```

### 2.3 scale（缩放）——改变大小

```css
transform: scale(1.2);
/* 效果：整体放大到 1.2 倍（120%） */

transform: scale(1.05);
/* 效果：轻微放大到 105%，hover 按钮常用 */

transform: scale(0.8);
/* 效果：缩小到 80% */

transform: scale(1.3, 0.7);
/* 效果：宽放大 1.3 倍，高缩到 0.7 倍（压扁） */
```

### 2.4 skew（倾斜）——平行四边形效果

```css
transform: skewX(20deg);
/* 效果：X 轴方向倾斜 20°，正方形变平行四边形 */

transform: skewY(10deg);
/* 效果：Y 轴方向倾斜 10° */
```

### 2.5 组合变换（多个一起写）

```css
transform: translateY(-10px) rotate(10deg) scale(1.05);
/*         ↑ 上移        ↑ 旋转       ↑ 放大  */
/* 效果：hover 时元素上浮、微微旋转、轻轻放大——三效合一 */
```

### 2.6 transform-origin（变换的原点/轴心）

```css
transform-origin: center center;   /* 默认：元素正中心（旋转绕中心转） */
transform-origin: left top;        /* 旋转时以左上角为轴心 */
transform-origin: right bottom;    /* 旋转时以右下角为轴心 */
transform-origin: 0 0;             /* 同 left top，用坐标表示 */
transform-origin: 50px 50px;       /* 从左上角往右 50px、往下 50px 的位置 */

/* 实战： */
.box { transform-origin: right bottom; }
.box:hover { transform: rotate(30deg); }
/* 效果：hover 时以右下角为中心旋转 30°，不是中心转 */
```

### 2.7 translate 居中技巧（重点！）

```css
/* 父元素 */
.parent {
  position: relative;
  width: 500px;
  height: 300px;
}

/* 子元素——真正居中 */
.child {
  position: absolute;
  top: 50%;                          /* 左上角移到父容器正中间 */
  left: 50%;
  transform: translate(-50%, -50%);  /* 再把自己往回移一半 → 完全居中 */
}
/* 效果：子元素不管多大，都绝对居中于父容器 */
/* 原理：top/left 的 50% 参考父容器，translate 的 50% 参考自身 */
```

### 2.8 3D 翻转卡片（完整代码模板）

```css
/* 外层容器：提供 3D 视角 */
.flip-card {
  width: 200px;
  height: 250px;
  perspective: 800px;         /* 透视距离，越小 3D 感越强 */
}

/* 内层：翻转主体 */
.flip-inner {
  width: 100%;
  height: 100%;
  transition: transform 0.6s;          /* 翻转动画 */
  transform-style: preserve-3d;        /* 保持 3D 空间 */
  position: relative;
}
.flip-card:hover .flip-inner {
  transform: rotateY(180deg);          /* hover 时绕 Y 轴翻 180° */
}

/* 正面和背面 */
.flip-front, .flip-back {
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;         /* 背面不可见（否则会透过来） */
  border-radius: 10px;
}
.flip-front { background: #4A90D9; }   /* 正面蓝色 */
.flip-back {
  background: #e67e22;                 /* 背面橙色 */
  transform: rotateY(180deg);          /* 预先翻过去 */
}
```

---

## 三、Animation（动画）

**作用**：比 transition 更强——可以定义多个关键帧，自动播放、无限循环。不需要 hover 触发。

### 3.1 两步创建动画

```css
/* 第1步：用 @keyframes 定义动画的关键帧 */
@keyframes myMove {
  0%   { transform: translateX(0);     background: blue; }
  50%  { transform: translateX(200px); background: red; }
  100% { transform: translateX(0);     background: blue; }
}
/* 0% = 动画开始时，50% = 动画一半时，100% = 动画结束时 */
/* from = 0%，to = 100%，可以混用 */

/* 第2步：把动画绑定到元素上 */
.box {
  animation: myMove 3s ease infinite;
  /*        ↑名称  ↑时长 ↑曲线 ↑无限循环 */
}
```

### 3.2 animation 简写（7 个值，按顺序写）

```css
animation: name duration timing-function delay iteration-count direction fill-mode;

/* 最简（只写名称+时长） */
animation: bounce 1s;

/* 常用（加 infinite 无限循环） */
animation: spin 2s linear infinite;

/* 完整（循环 3 次，来回播放，结束后保持） */
animation: fadeIn 1s ease 0s 3 alternate both;
```

### 3.3 拆解属性详解

```css
animation-name: bounce;
/* 指定用哪个 @keyframes，名字要一致 */

animation-duration: 2s;
/* 动画播一遍的时长。1s = 1 秒，500ms = 0.5 秒 */

animation-timing-function: ease;
/* 速度曲线，跟 transition 一样：ease | linear | ease-in | ease-out | ease-in-out */

animation-delay: 0.5s;
/* 延迟 0.5s 才开始播。默认 0s 立即开始 */
/* 也可以填负值如 -1s：跳过 1s 直接播后面的 */

animation-iteration-count: infinite;
/* 播放次数：1（默认，只播一次）| 3（播 3 次）| infinite（无限循环） */

animation-direction: normal;
/* normal（默认，0%→100%） */
/* reverse（反过来，100%→0%） */
/* alternate（来回：0%→100%→0%→100%...） */
/* 配合 infinite 用 alternate 实现呼吸/弹跳的来回效果 */

animation-fill-mode: forwards;
/* none（默认，播完回到初始状态） */
/* forwards（播完后保持最后一帧的状态不动） */
/* backwards（在延迟期间就应用第一帧的样式） */
/* both（同时有 forwards 和 backwards 的效果）*/
```

### 3.4 常用动画模板（直接复制）

```css
/* ---- 渐入+上浮（页面加载用） ---- */
@keyframes fadeInUp {
  from {
    opacity: 0;                    /* 一开始完全透明 */
    transform: translateY(30px);   /* 一开始在下方 30px */
  }
  to {
    opacity: 1;                    /* 结束时完全不透明 */
    transform: translateY(0);      /* 结束时回到原位 */
  }
}
/* 使用：animation: fadeInUp 0.8s ease both; */

/* ---- 渐入（纯淡入，不位移） ---- */
@keyframes fadeIn {
  from { opacity: 0; }
  to   { opacity: 1; }
}
/* 使用：animation: fadeIn 1s ease; */

/* ---- 心跳/呼吸 ---- */
@keyframes pulse {
  0%, 100% { transform: scale(1);     }   /* 原始大小 */
  50%      { transform: scale(1.3);   }   /* 中间放大到 1.3 倍 */
}
/* 使用：animation: pulse 1.2s ease-in-out infinite; */
/* 效果：元素不停地在原始大小和 1.3 倍之间缩放 */

/* ---- 无限旋转加载 ---- */
@keyframes spin {
  to { transform: rotate(360deg); }
}
/* 使用：animation: spin 0.8s linear infinite; */
/* 效果：元素匀速不停旋转，做 loading 图标 */

/* ---- 弹跳 ---- */
@keyframes bounce {
  0%, 100% { transform: translateY(0);      }
  50%      { transform: translateY(-60px);  }
}
/* 使用：animation: bounce 0.8s ease-in-out infinite; */
/* 效果：元素上下弹跳，中间跳到最高点 */

/* ---- 左右摇晃 ---- */
@keyframes shake {
  0%, 100% { transform: translateX(0);      }
  25%      { transform: translateX(-10px);  }  /* 左摇 */
  75%      { transform: translateX(10px);   }  /* 右摇 */
}
/* 使用：animation: shake 0.5s ease; */
/* 效果：快速左右晃，做错误提示。只播一次不循环 */

/* ---- 从左滑入 ---- */
@keyframes slideInLeft {
  from { transform: translateX(-100px); opacity: 0; }
  to   { transform: translateX(0);       opacity: 1; }
}
/* 使用：animation: slideInLeft 0.5s ease both; */

/* ---- 从上方掉入（带弹跳感） ---- */
@keyframes dropIn {
  0%   { transform: translateY(-80px); opacity: 0; }
  60%  { transform: translateY(5px);   opacity: 1; }  /* 掉过一点 */
  80%  { transform: translateY(-3px);  }               /* 弹回一点 */
  100% { transform: translateY(0);     }
}
/* 使用：animation: dropIn 0.6s ease; */
```

### 3.5 @keyframes 的两种写法

```css
/* 写法1：from...to...（只有两帧） */
@keyframes simple {
  from { opacity: 0; }
  to   { opacity: 1; }
}

/* 写法2：百分比（多帧，更精细） */
@keyframes detailed {
  0%   { opacity: 0; transform: scale(0.5); }
  30%  { opacity: 0.5; }
  70%  { opacity: 1; transform: scale(1.1); }
  100% { opacity: 1; transform: scale(1); }
}
```

### 3.6 steps() 逐帧动画

```css
/* steps(步数) 让动画"跳着播"而不是平滑过渡 */
animation: typing 1s steps(3) infinite;
/* 效果：把 1s 分成 3 步，每步跳变一次 */
/* 常用 steps(1) 做光标闪烁 */
@keyframes blink {
  0%, 100% { opacity: 1; }
  50%      { opacity: 0; }
}
.cursor {
  animation: blink 0.8s steps(1) infinite;
}
```

---

## 四、transition + transform 组合实战（最常用）

```css
/* 套路1：hover 按钮上浮 */
.btn {
  transition: transform 0.2s, box-shadow 0.2s;
}
.btn:hover {
  transform: translateY(-3px);                          /* 上浮 */
  box-shadow: 0 6px 20px rgba(0,0,0,0.2);              /* 加阴影 */
}

/* 套路2：hover 卡片放大 */
.card {
  transition: transform 0.35s, box-shadow 0.35s;
}
.card:hover {
  transform: scale(1.03);                               /* 轻微放大 */
  box-shadow: 0 12px 30px rgba(0,0,0,0.15);            /* 阴影加深 */
}

/* 套路3：hover 图片放大（容器 overflow:hidden 必须！） */
.img-box {
  overflow: hidden;                    /* 防止放大后的图片溢出 */
  border-radius: 8px;
}
.img-box img {
  transition: transform 0.4s;
}
.img-box:hover img {
  transform: scale(1.2);              /* 图片放大 1.2 倍 */
}

/* 套路4：输入框 focus 发光 */
input {
  border: 2px solid #ddd;
  transition: border-color 0.3s, box-shadow 0.3s;
}
input:focus {
  border-color: #4A90D9;
  box-shadow: 0 0 0 3px rgba(74,144,217,0.2);  /* 外发光圈 */
  outline: none;
}
```

---

## 五、三者对比

| | transition | transform | animation |
|---|---|---|---|
| **作用** | 让属性变化变平滑 | 移动/旋转/缩放/倾斜元素 | 自动播放多段动画 |
| **怎么触发** | 必须有状态变化（hover/focus/加class） | 通常写在 hover 里配合 transition | 页面加载就自动播 |
| **能循环吗** | 不能（hover 移开就回去了） | 不能 | 能（`infinite`） |
| **能分阶段吗** | 不能（只 A→B 单向） | 不能 | 能（0%→25%→50%→100%） |
| **脱离文档流** | 无关 | 不脱离（原坑位保留） | 无关 |

### 怎么选

```
想要 hover 时平滑变色/变位置 → transition
想要移动/旋转/缩放元素       → transform（通常配 transition）
想要自动播放、循环的动画     → animation
```

---

## 六、一句话速记

- **transition**：`transition: all 0.3s ease;` → hover 时属性值平滑过渡
- **transform**：`transform: translateY(-10px) scale(1.1);` → 改变位置和大小
- **transform-origin**：`transform-origin: center;` → 旋转/缩放的轴心在哪
- **@keyframes**：`@keyframes 名 { 0%{} 50%{} 100%{} }` → 定义动画的阶段
- **animation**：`animation: 名 1s ease infinite;` → 把动画绑到元素上
