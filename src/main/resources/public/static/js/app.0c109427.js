(function(t){function e(e){for(var r,o,s=e[0],u=e[1],c=e[2],l=0,p=[];l<s.length;l++)o=s[l],a[o]&&p.push(a[o][0]),a[o]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(t[r]=u[r]);f&&f(e);while(p.length)p.shift()();return i.push.apply(i,c||[]),n()}function n(){for(var t,e=0;e<i.length;e++){for(var n=i[e],r=!0,o=1;o<n.length;o++){var s=n[o];0!==a[s]&&(r=!1)}r&&(i.splice(e--,1),t=u(u.s=n[0]))}return t}var r={},o={app:0},a={app:0},i=[];function s(t){return u.p+"static/js/"+({}[t]||t)+"."+{"chunk-0b59b26e":"9bb66235","chunk-29d39c14":"833bdd6a","chunk-2ca6356f":"2cde463c","chunk-2d0df233":"237a88d4"}[t]+".js"}function u(e){if(r[e])return r[e].exports;var n=r[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,u),n.l=!0,n.exports}u.e=function(t){var e=[],n={"chunk-0b59b26e":1,"chunk-29d39c14":1,"chunk-2ca6356f":1};o[t]?e.push(o[t]):0!==o[t]&&n[t]&&e.push(o[t]=new Promise(function(e,n){for(var r="static/css/"+({}[t]||t)+"."+{"chunk-0b59b26e":"b4440ec6","chunk-29d39c14":"06112790","chunk-2ca6356f":"257f1eb6","chunk-2d0df233":"31d6cfe0"}[t]+".css",a=u.p+r,i=document.getElementsByTagName("link"),s=0;s<i.length;s++){var c=i[s],l=c.getAttribute("data-href")||c.getAttribute("href");if("stylesheet"===c.rel&&(l===r||l===a))return e()}var p=document.getElementsByTagName("style");for(s=0;s<p.length;s++){c=p[s],l=c.getAttribute("data-href");if(l===r||l===a)return e()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=e,f.onerror=function(e){var r=e&&e.target&&e.target.src||a,i=new Error("Loading CSS chunk "+t+" failed.\n("+r+")");i.request=r,delete o[t],f.parentNode.removeChild(f),n(i)},f.href=a;var m=document.getElementsByTagName("head")[0];m.appendChild(f)}).then(function(){o[t]=0}));var r=a[t];if(0!==r)if(r)e.push(r[2]);else{var i=new Promise(function(e,n){r=a[t]=[e,n]});e.push(r[2]=i);var c,l=document.getElementsByTagName("head")[0],p=document.createElement("script");p.charset="utf-8",p.timeout=120,u.nc&&p.setAttribute("nonce",u.nc),p.src=s(t),c=function(e){p.onerror=p.onload=null,clearTimeout(f);var n=a[t];if(0!==n){if(n){var r=e&&("load"===e.type?"missing":e.type),o=e&&e.target&&e.target.src,i=new Error("Loading chunk "+t+" failed.\n("+r+": "+o+")");i.type=r,i.request=o,n[1](i)}a[t]=void 0}};var f=setTimeout(function(){c({type:"timeout",target:p})},12e4);p.onerror=p.onload=c,l.appendChild(p)}return Promise.all(e)},u.m=t,u.c=r,u.d=function(t,e,n){u.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},u.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},u.t=function(t,e){if(1&e&&(t=u(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(u.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)u.d(n,r,function(e){return t[e]}.bind(null,r));return n},u.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return u.d(e,"a",e),e},u.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},u.p="/",u.oe=function(t){throw console.error(t),t};var c=window["webpackJsonp"]=window["webpackJsonp"]||[],l=c.push.bind(c);c.push=e,c=c.slice();for(var p=0;p<c.length;p++)e(c[p]);var f=l;i.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},4633:function(t,e,n){},"56d7":function(t,e,n){"use strict";n.r(e);n("cadf"),n("551c"),n("f751"),n("097d");var r=n("2b0e"),o=n("9f7b"),a=n("31bd"),i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("router-view")},s=[],u={name:"App"},c=u,l=(n("5c0b"),n("2877")),p=Object(l["a"])(c,i,s,!1,null,null,null),f=p.exports,m=(n("7f7f"),n("8c4f")),h=function(){return n.e("chunk-29d39c14").then(n.bind(null,"4840"))},g=function(){return n.e("chunk-0b59b26e").then(n.bind(null,"6032"))},d=function(){return n.e("chunk-2d0df233").then(n.bind(null,"8940"))},v=function(){return n.e("chunk-2ca6356f").then(n.bind(null,"cfcb"))},b=[{path:"/",redirect:"/main",name:"Главная",component:h,children:[{path:"main",name:"Главная",component:d},{path:"/wifi/points",name:"Точки доступа",component:g},{path:"/wifi/points/history",name:"История по точкам доступа",component:d},{path:"/wifi/clients",name:"Клиенты",component:d},{path:"/wifi/clients/history",name:"История по клиентам",component:d},{path:"/wifi/sectors",name:"Зоны",component:d},{path:"/wifi/sensors",name:"Датчики",component:d},{path:"/wifi/statistics",name:"Статистика",component:d},{path:"wifi/reports",name:"Отчеты по точкам доступа и клиентам",component:d},{path:"/gsm/cellular",name:"Сотовые устройства",component:d},{path:"/gsm/cellular/history",name:"История по сотовым устройствам",component:d},{path:"/gsm/sensors",name:"Датчики",component:d},{path:"/gsm/statistics",name:"Статистика",component:d},{path:"/gsm/reports",name:"Отчеты",component:d},{path:"wifi/reports",name:"Отчеты по сотовым устройствам",component:d},{path:"/settings/user",name:"Настройка пользователей",component:d},{path:"/settings/system",name:"Настройка системы",component:d},{path:"/settings/floors",name:"Настройка этажей",component:d},{path:"/settings/triggers",name:"Настройка тригеров",component:d},{path:"/settings/sectors",name:"Найстрока зон",component:d},{path:"/notifications",name:"События",component:d}]},{name:"login",path:"login",component:v,meta:{isPublic:!0}}];r["default"].use(m["a"]);var w=new m["a"]({mode:"hash",linkActiveClass:"open active",scrollBehavior:function(){return{y:0}},routes:b}),L=function(){return localStorage.getItem("token")};w.beforeEach(function(t,e,n){return t.meta.isPublic||L()?"login"===t.name&&L()?n({name:"main"}):n():n({name:"login"})});var k=w,y=n("2f62"),E=(n("96cf"),n("3b8d")),O=(n("6762"),n("2fdb"),n("bc3a")),P=n.n(O),x=window.location.href.includes("localhost")?"http://localhost:8088/api":"http://91.226.80.185:8088/api",G=P.a.create({baseURL:x,withCredentials:!0});function R(t){var e=t.status,n=t.headers;if(e>=200&&e<303){var r=n["content-type"],o=r&&r.includes("application/json");return o?t.data:t.text}throw new Error(t.statusText)}function j(t){var e=t.response,n=e.status;throw 401===n&&(localStorage.removeItem("token"),localStorage.removeItem("userLogin"),k.push({path:"/login"})),new Error(e)}function A(t,e){return G.get("/login",{auth:{username:t,password:e}}).then(function(t){return R(t)})}var M={logout:function(t){t.token=null,t.userLogin=null,localStorage.removeItem("token"),localStorage.removeItem("userLogin")},startLogin:function(t){t.status="LOADING",t.errorMessage=null},finishLogin:function(t,e){var n=e.token,r=e.username;t.status="LOADED",t.errorMessage=null,t.token=n,t.userLogin=r,localStorage.setItem("token",n),localStorage.setItem("userLogin",r)},failLogin:function(t,e){t.status="LOADING_ERROR",t.errorMessage=e}},S={authentication:function(){var t=Object(E["a"])(regeneratorRuntime.mark(function t(e,n){var r,o,a,i;return regeneratorRuntime.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return r=e.commit,o=n.userLogin,a=n.password,r("startLogin"),t.prev=3,t.next=6,A(o,a);case 6:i=t.sent,r("finishLogin",i),k.push({path:"/main"}),t.next=14;break;case 11:t.prev=11,t.t0=t["catch"](3),r("failLogin",t.t0.message);case 14:case"end":return t.stop()}},t,this,[[3,11]])}));function e(e,n){return t.apply(this,arguments)}return e}(),logout:function(t){var e=t.commit;e("logout"),k.push({path:"/login"})}},I={getUserLogin:function(){return localStorage.getItem("userLogin")}},D={userLogin:null,token:null,status:null,errorMessage:null},N={namespaced:!0,state:D,mutations:M,actions:S,getters:I};function _(t){return G.get("/pointevent",{params:t}).then(function(t){return R(t)}).catch(function(t){return j(t)})}function T(t){var e=t.pointId,n=t.pointList;return G.put("/point/".concat(e,"/list"),n).then(function(t){return R(t)}).catch(function(t){return j(t)})}var C={startGetPointsEvent:function(t){t.status="LOADING",t.errorMessage=null},finishGetPointsEvent:function(t,e){t.status="LOADED",t.errorMessage=null,t.pointsEvent=e},failGetPointsEvent:function(t,e){t.status="LOADING_ERROR",t.errorMessage=e,t.pointsEvent=[]}},B={getPointsEvent:function(){var t=Object(E["a"])(regeneratorRuntime.mark(function t(e,n){var r,o;return regeneratorRuntime.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return r=e.commit,o=e.state,"LOADED"!==o.status&&r("startGetPointsEvent"),t.prev=2,t.t0=r,t.next=6,_(n);case 6:t.t1=t.sent,(0,t.t0)("finishGetPointsEvent",t.t1),t.next=13;break;case 10:t.prev=10,t.t2=t["catch"](2),r("failGetPointsEvent");case 13:case"end":return t.stop()}},t,this,[[2,10]])}));function e(e,n){return t.apply(this,arguments)}return e}(),updatePointList:function(){var t=Object(E["a"])(regeneratorRuntime.mark(function t(e,n){return regeneratorRuntime.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,T(n);case 2:case"end":return t.stop()}},t,this)}));function e(e,n){return t.apply(this,arguments)}return e}()},q={pointsEvent:null,status:null,errorMessage:null},J={namespaced:!0,state:q,mutations:C,actions:B};function U(){return G.get("/pointList").then(function(t){return R(t)}).catch(function(t){return j(t)})}var $={startGetPointList:function(t){t.status="LOADING",t.errorMessage=null},finishGetPointList:function(t,e){t.status="LOADED",t.errorMessage=null,t.pointList=e},failGetPointList:function(t,e){t.status="LOADING_ERROR",t.errorMessage=e,t.pointList=[]}},z={pointList:function(t){var e=t.pointList;return e.map(function(t){return{value:t.id,text:t.name}})}},F={getPointList:function(){var t=Object(E["a"])(regeneratorRuntime.mark(function t(e){var n;return regeneratorRuntime.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.commit,n("startGetPointList"),t.prev=2,t.t0=n,t.next=6,U();case 6:t.t1=t.sent,(0,t.t0)("finishGetPointList",t.t1),t.next=13;break;case 10:t.prev=10,t.t2=t["catch"](2),n("failGetPointList");case 13:case"end":return t.stop()}},t,this,[[2,10]])}));function e(e){return t.apply(this,arguments)}return e}()},H={pointList:null,status:null,errorMessage:null},K={namespaced:!0,state:H,mutations:$,actions:F,getters:z};r["default"].use(y["a"]);var Q=new y["a"].Store({modules:{authentication:N,points:J,pointList:K}}),V=Q;n("f466"),n("579f"),n("587a"),n("54ba"),n("f9e3"),n("2dd8");r["default"].config.productionTip=!1,r["default"].use(o["a"]),Object(a["sync"])(V,k),new r["default"]({router:k,store:V,render:function(t){return t(f)}}).$mount("#app")},"5c0b":function(t,e,n){"use strict";var r=n("4633"),o=n.n(r);o.a}});
//# sourceMappingURL=app.0c109427.js.map